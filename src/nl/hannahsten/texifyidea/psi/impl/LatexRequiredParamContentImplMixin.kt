package nl.hannahsten.texifyidea.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.ElementManipulators
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import nl.hannahsten.texifyidea.psi.LatexRequiredParamContent

abstract class LatexRequiredParamContentImplMixin(node: ASTNode) : ASTWrapperPsiElement(node), LatexRequiredParamContent {

    override fun isValidHost(): Boolean {
        return true
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        return ElementManipulators.handleContentChange(this, text)
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<LatexRequiredParamContent> {
        return LiteralTextEscaper.createSimple(this)
    }
}