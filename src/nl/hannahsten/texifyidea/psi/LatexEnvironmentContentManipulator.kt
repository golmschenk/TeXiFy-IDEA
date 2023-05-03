package nl.hannahsten.texifyidea.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import nl.hannahsten.texifyidea.grammar.LatexLanguage
import nl.hannahsten.texifyidea.psi.impl.LatexEnvironmentContentImpl

/**
 * Enable editing environment content in a separate window (when using language injection).
 */
class LatexEnvironmentContentManipulator : AbstractElementManipulator<LatexEnvironmentContentImpl>() {

    override fun handleContentChange(
            element: LatexEnvironmentContentImpl,
            range: TextRange,
            newContent: String
    ): LatexEnvironmentContentImpl? {
        val file = PsiFileFactory.getInstance(element.project)
                .createFileFromText("temp.tex", LatexLanguage, newContent)
        val res = PsiTreeUtil.findChildOfType(file, LatexEnvironmentContentImpl::class.java) ?: return null
        element.replace(res)
        return element
    }
}
