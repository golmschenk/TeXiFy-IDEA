// This is a generated file. Not intended for manual editing.
package nl.hannahsten.texifyidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.LiteralTextEscaper;

public interface LatexEnvironmentContent extends PsiLanguageInjectionHost {

  @NotNull
  List<LatexNoMathContent> getNoMathContentList();

  boolean isValidHost();

  PsiLanguageInjectionHost updateText(@NotNull String text);

  @NotNull LiteralTextEscaper<LatexEnvironmentContent> createLiteralTextEscaper();

}
