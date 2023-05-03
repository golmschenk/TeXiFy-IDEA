package nl.hannahsten.texifyidea.psi

import com.intellij.lang.Language
import com.intellij.lang.LanguageParserDefinitions
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import nl.hannahsten.texifyidea.lang.magic.DefaultMagicKeys
import nl.hannahsten.texifyidea.lang.magic.magicComment
import nl.hannahsten.texifyidea.util.camelCase
import nl.hannahsten.texifyidea.util.magic.CommandMagic
import nl.hannahsten.texifyidea.util.magic.EnvironmentMagic
import nl.hannahsten.texifyidea.util.parentOfType
import nl.hannahsten.texifyidea.util.remove
import java.util.*

/**
 * External language injection.
 *
 * @author Sten Wessel
 */
class LatexLanguageInjectionContributor : LanguageInjectionContributor {
    override fun getInjection(context: PsiElement): Injection? {
        var language: Language? = null
        if (context is LatexEnvironmentContent) {
            if (context.parent is LatexEnvironment) {
                val host = context.parent as LatexEnvironment
                val magicComment = host.magicComment()
                val hasMagicCommentKey = magicComment.containsKey(DefaultMagicKeys.INJECT_LANGUAGE)

                val languageId = when {
                    hasMagicCommentKey -> {
                        magicComment.value(DefaultMagicKeys.INJECT_LANGUAGE)
                    }

                    host.environmentName == "lstlisting" -> {
                        host.beginCommand.optionalParameterMap.toStringMap().getOrDefault("language", null)
                    }

                    host.environmentName in EnvironmentMagic.languageInjections.keys -> {
                        EnvironmentMagic.languageInjections[host.environmentName]
                    }

                    host.environmentName.endsWith("code", ignoreCase = false) -> {
                        // Environment may have been defined with the \newminted shortcut (see minted documentation)
                        host.environmentName.remove("code")
                    }

                    else -> {
                        null
                    }
                } ?: return null

                language = findLanguage(languageId) ?: return null

                // A parser definition is required
                if (LanguageParserDefinitions.INSTANCE.forLanguage(language) == null) return null
            }
        }

        if (context is LatexRequiredParamContent) {
            if (context.parent is LatexRequiredParam) {
                if (context.parent.parent is LatexParameter) {
                    val parameter = context.parent.parent as LatexParameter
                    val parent = parameter.parentOfType(LatexCommands::class) ?: return null

                    val languageId = CommandMagic.languageInjections[parent.commandToken.text.substring(1)]
                    language = findLanguage(languageId) ?: return null
                }
            }
        }

        language ?: return null
        if (LanguageParserDefinitions.INSTANCE.forLanguage(language) == null) return null
        return SimpleInjection(language, "", "", null)
    }

    private fun findLanguage(id: String?): Language? {
        return if (id.isNullOrBlank()) null
        else {
            Language.findLanguageByID(id)
                    ?: Language.findLanguageByID(id.lowercase(Locale.getDefault()))
                    ?: Language.findLanguageByID(id.uppercase(Locale.getDefault()))
                    ?: Language.findLanguageByID(id.camelCase())
        }
    }
}