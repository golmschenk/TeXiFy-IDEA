package nl.hannahsten.texifyidea.templates.postfix

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import nl.hannahsten.texifyidea.lang.Package
import nl.hannahsten.texifyidea.util.insertUsepackage

abstract class LatexPostfixTemplateFromPackageProvider(private val pack: Package) : PostfixTemplateProvider {
    override fun getPresentableName(): String? = "LaTeX"

    abstract override fun getTemplates(): MutableSet<PostfixTemplate>

    override fun isTerminalSymbol(currentChar: Char): Boolean =
            (currentChar == '.')

    override fun afterExpand(file: PsiFile, editor: Editor) {
        file.insertUsepackage(pack)
    }

    override fun preCheck(copyFile: PsiFile, realEditor: Editor, currentOffset: Int): PsiFile =
            copyFile

    override fun preExpand(file: PsiFile, editor: Editor) {}

    companion object {
        fun getProvider(pack: Package?): PostfixTemplateProvider {
            return when(pack) {
                Package.AMSFONTS -> LatexPostfixTemplateFromAmsFontsProvider
                else -> LatexPostFixTemplateProvider
            }
        }
    }
}

object LatexPostfixTemplateFromAmsFontsProvider : LatexPostfixTemplateFromPackageProvider(Package.AMSFONTS) {
    override fun getTemplates(): MutableSet<PostfixTemplate> = mutableSetOf(
            LatexWrapWithMathbbPostfixTemplate
    )
}