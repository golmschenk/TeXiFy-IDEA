package nl.hannahsten.texifyidea.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import nl.hannahsten.texifyidea.grammar.LatexLanguage

/**
 * Enable editing parameter text in a separate window (when using language injection).
 */
class LatexRequiredParamContentManipulator : AbstractElementManipulator<LatexRequiredParamContent>() {

    override fun handleContentChange(
            element: LatexRequiredParamContent,
            range: TextRange,
            newContent: String
    ): LatexRequiredParamContent? {
        val file = PsiFileFactory.getInstance(element.project)
                .createFileFromText("temp.tex", LatexLanguage, newContent)
        val res = PsiTreeUtil.findChildOfType(file, LatexRequiredParamContent::class.java) ?: return null
        element.replace(res)
        return element
    }
}
