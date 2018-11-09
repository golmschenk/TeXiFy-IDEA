package nl.rubensten.texifyidea.lang

import nl.rubensten.texifyidea.lang.Argument.Type
import nl.rubensten.texifyidea.lang.Package.Companion.AMSMATH
import nl.rubensten.texifyidea.lang.Package.Companion.BIBLATEX
import nl.rubensten.texifyidea.lang.Package.Companion.DEFAULT
import nl.rubensten.texifyidea.lang.Package.Companion.FONTENC
import nl.rubensten.texifyidea.lang.Package.Companion.GRAPHICX
import nl.rubensten.texifyidea.lang.Package.Companion.ULEM

/**
 * @author Sten Wessel
 */
enum class LatexNoMathCommand(
        override val command: String,
        override vararg val arguments: Argument = emptyArray(),
        override val dependency: Package = DEFAULT,
        override val display: String? = null
) : LatexCommand {

    ADDTOCOUNTER("addtocounter", "countername".asRequired(), "value".asRequired()),
    A_RING("aa", display = "å"),
    CAPITAL_A_RING("AA", display = "Å"),
    ADDBIBRESOURCE("addbibresource", RequiredFileArgument("bibliographyfile", "bib"), dependency = BIBLATEX),
    AE("ae", display = "æ"),
    CAPITAL_AE("AE", display = "Æ"),
    APPENDIX("appendix"),
    AUTHOR("author", "name".asRequired(Type.TEXT)),
    AUTOREF("autoref", "label".asRequired(Type.TEXT), dependency = Package.HYPERREF),
    BEGIN("begin", "environment".asRequired()),
    END("end", "environment".asRequired()),
    ENSUREMATH("ensuremath", "text".asRequired()),
    BASELINESKIP("baselineskip"),
    BASELINESTRETCH("baselinestretch "),
    BFSERIES("bfseries"),
    BIBITEM("bibitem", "label".asOptional(), "citekey".asRequired()),
    BIBLIOGRAPHYSTYLE("bibliographystyle", "style".asRequired()),
    BIBLIOGRAPHY("bibliography", RequiredFileArgument("bibliographyfile", "bib")),
    BIGSKIP("bigskip"),
    BOLDMATH("boldmath"),
    CAPTION("caption", "shorttext".asOptional(), "text".asRequired(Type.TEXT)),
    CHAPTER("chapter", "shorttitle".asOptional(), "title".asRequired(Type.TEXT)),
    CHAPTER_STAR("chapter*", "title".asRequired(Type.TEXT)),
    CITE("cite", "extratext".asOptional(), "keys".asRequired()),
    CLEARDOUBLEPAGE("cleardoublepage"),
    CLEARPAGE("clearpage"),
    COLUMNSEP("columnsep "),
    COLUMNWIDTH("columnwidth"),
    CONTENTSLINE("contentsline", "type".asRequired(), "text".asRequired(Type.TEXT), "page".asRequired()),
    CONTENTSNAME("contentsname", "name".asRequired()),
    DATE("date", "text".asRequired(Type.TEXT)),
    DECLARE_MATH_OPERATOR("DeclareMathOperator", "command".asRequired(), "operator".asRequired(Type.TEXT)),
    DEF("def"),
    DOCUMENTCLASS("documentclass", "options".asOptional(), "class".asRequired()),
    DOTFILL("dotfill"),
    EM("em"),
    EMPH("emph", "text".asRequired(Type.TEXT)),
    ENLARGETHISPAGE("enlargethispage", "size".asRequired()),
    ENLARGETHISPAGE_STAR("enlargethispage*", "size".asRequired()),
    EQREF("eqref", "eqLabel".asRequired(Type.TEXT), dependency = AMSMATH),
    EVENSIDEMARGIN("evensidemargin"),
    FAMILY("family"),
    FBOX("fbox", "text".asRequired(Type.TEXT)),
    FIGURENAME("figurename", "name".asRequired(Type.TEXT)),
    FLQ("flq", display = "‹"),
    FLQQ("flqq", display = "«"),
    FLUSHBOTTOM("flushbottom"),
    FLUSHLEFT("flushleft"),
    FLUSHRIGHT("flushright"),
    FONTENCODING("fontencoding", "enc".asRequired()),
    FONTFAMILY("fontfamily", "family".asRequired()),
    FONTSERIES("fontseries", "series".asRequired()),
    FONTSHAPE("fontshape", "shape".asRequired()),
    FONTSIZE("fontsize", "size".asRequired(), "skip".asRequired()),
    FOOTNOTESIZE("footnotesize"),
    FOOTNOTETEXT("footnotetext", "number".asOptional(), "text".asRequired(Type.TEXT)),
    FOOTNOTE("footnote", "number".asOptional(), "text".asRequired(Type.TEXT)),
    FOOTNOTEMARK("footnotemark"),
    FRAMEBOX("framebox", "width".asOptional(), "pos".asOptional(), "text".asOptional(Type.TEXT)),
    FRAME("frame", "text".asRequired(Type.TEXT)),
    FRQ("frq", display = "›"),
    FRQQ("frqq", display = "»"),
    FULLREF("fullref", "label".asRequired(Type.TEXT), dependency = Package.HYPERREF),
    GLOSSARYENTRY("glossaryentry", "text".asRequired(Type.TEXT), "pagenum".asRequired()),
    GLOSSARY("glossary", "text".asRequired(Type.TEXT)),
    GLQ("glq", display = ","),
    GLQQ("glqq", display = "„"),
    GRQ("grq", display = "‘"),
    GRQQ("grqq", display = "“"),
    GUILLEMOTLEFT("guillemotleft", dependency = FONTENC.with("T1"), display = "«"),
    GUILLEMOTRIGHT("guillemotright", dependency = FONTENC.with("T1"), display = "»"),
    HFILL("hfill"),
    HRULE("hrule"),
    HRULEFILL("hrulefill"),
    HSPACE("hspace", "length".asRequired()),
    HSPACE_STAR("hspace*", "length".asRequired()),
    HSS("hss"),
    HUGE("huge"),
    CAPITAL_HUGE("Huge"),
    HYPERREF("hyperref", "options".asOptional(), "label".asRequired(Type.TEXT), dependency = Package.HYPERREF),
    HYPHENATION("hyphenation", "words".asRequired(Type.TEXT)),
    I("i", display = "i (dotless)"),
    INCLUDE("include", RequiredFileArgument("sourcefile", "tex")),
    INPUT("input", RequiredFileArgument("sourcefile", "tex")),
    INCLUDEGRAPHICS("includegraphics", "key-val-list".asOptional(), RequiredFileArgument("imagefile", "pdf", "png", "jpg", "eps"), dependency = GRAPHICX),
    INCLUDEONLY("includeonly", RequiredFileArgument("sourcefile", "tex")),
    INDEXNAME("indexname", "name".asRequired()),
    INDEXSPACE("indexspace"),
    INDEX("intex", "entry".asRequired()),
    ITEM("item", "label".asOptional()),
    ITSHAPE("itshape"),
    LABEL("label", "key".asRequired()),
    LARGE("large"),
    CAPITAL_LARGE("Large"),
    SCREAMING_LARGE("LARGE"),
    LATEX("LaTeX", display = "LaTeX"),
    LATEXE("LaTeXe", display = "LaTeX2ε"),
    LDOTS("ldots", display = "…"),
    LEFTEQN("lefteqn"),
    LET("let"),
    LFSERIES("lfseries"),
    LINEBREAK("linebreak", "number".asOptional()),
    LINETHICKNESS("linethickness", "dimension".asRequired()),
    LINEWIDTH("linewidth"),
    LISTFIGURENAME("listfigurename", "name".asRequired(Type.TEXT)),
    LISTFILES("listfiles"),
    LISTOFFIGURES("listoffigures"),
    LISTOFTABLES("listoftables"),
    LISTTABLENAME("listtablename", "name".asRequired(Type.TEXT)),
    LOWERCASE("lowercase", "text".asRequired(Type.TEXT)),
    MAKEGLOSSARY("makeglossary"),
    MAKEINDEX("makeindex"),
    MAKELABEL("makelabel"),
    MAKELABELS("makelabels", "number".asRequired()),
    MAKETITLE("maketitle"),
    MBOX("mbox", "text".asRequired()),
    MDSERIES("mdseries"),
    MEDSKIP("medskip"),
    MULTICOLUMN("multicolumn", "cols".asRequired(), "pos".asRequired(), "text".asRequired(Type.TEXT)),
    NAMEREF("nameref", "label".asRequired(Type.TEXT), dependency = Package.HYPERREF),
    NEWLABEL("newlabel"),
    NEWLENGTH("newlength", "length".asRequired()),
    NEWLINE("newline"),
    NEWPAGE("newpage"),
    NEWTHEOREM("newtheorem", "envname".asRequired(), "numberedlike".asOptional(), "caption".asRequired(Type.TEXT), "within".asOptional()),
    NEWTHEOREM_STAR("newtheorem*", "envname".asRequired(), "caption".asRequired(Type.TEXT)),
    NOCITE("nocite", "keys".asRequired()),
    NOFILES("nofiles"),
    NOLINEBREAK("nolinebreak", "number".asOptional()),
    NONUMBER("nonumber"),
    NOPAGEBREAK("nopagebreak", "number".asOptional()),
    NORMALCOLOR("normalcolor"),
    NORMALFONT("normalfont"),
    NORMALSIZE("normalsize"),
    OE("oe", display = "œ"),
    CAPITAL_OE("OE", display = "Œ"),
    ODDSIDEMARGIN("oddsidemargin"),
    ONECOLUMN("onecolumn"),
    PAGEBREAK("pagebreak", "number".asOptional()),
    PAGENAME("pagename"),
    PAGENUMBERING("pagenumbering", "numstyle".asRequired()),
    PAGEREF("pageref", "label".asRequired()),
    PAGESTYLE("pagestyle", "style".asRequired()),
    PAGETOTAL("pagetotal"),
    PAPERWIDTH("paperwidth"),
    PAPERHEIGHT("paperheight"),
    PARAGRAPH("paragraph", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    PARAGRAPH_STAR("paragraph*", "title".asRequired(Type.TEXT)),
    PARAGRAPHMARK("paragraphmark"),
    PARBOX("parbox", "pos".asOptional(), "width".asRequired(), "text".asRequired(Type.TEXT)),
    PARINDENT("parindent"),
    PARSKIP("parskip"),
    PART("part", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    PART_STAR("part*", "title".asRequired(Type.TEXT)),
    PARTNAME("partname", "name".asRequired(Type.TEXT)),
    PDFINFO("pdfinfo", "info".asRequired(Type.TEXT)),
    POUNDS("pounds", display = "£"),
    PRINTBIBLIOGRAPHY("printbibliography", dependency = BIBLATEX),
    PRINTINDEX("printindex"),
    R("r", display = "˚ (accent)"),
    REF("ref", "label".asRequired()),
    REFNAME("refname", "name".asRequired(Type.TEXT)),
    REQUIREPACKAGE("RequirePackage", "options".asOptional(), "package".asRequired()),
    RIGHTHYPHENMIN("righthyphenmin"),
    RIGHTMARGIN("rightmargin"),
    RIGHTMARK("rightmark"),
    RMFAMILY("rmfamily"),
    ROMAN("roman", "counter".asRequired()),
    ROTATEBOX("rotatebox", "key-val-list".asOptional(), "degrees".asRequired(), "text".asRequired(Type.TEXT), dependency = GRAPHICX),
    CAPITAL_ROBAN("Roman", "counter".asRequired()),
    RULE("rule", "line".asOptional(), "width".asRequired(), "thickness".asRequired()),
    SAMEPAGE("samepage"),
    SBOX("sbox", "cmd".asRequired(), "length".asRequired()),
    SCRIPTSIZE("scriptsize"),
    SCSHAPE("scshape"),
    SECTION("section", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SECTION_STAR("section*", "title".asRequired(Type.TEXT)),
    SELECTFONT("selectfont"),
    SETCOUNTER("setcounter", "countername".asRequired(), "value".asRequired()),
    SETLENGTH("setlength", "cmd".asRequired(), "length".asRequired()),
    SFFAMILY("sffamily"),
    SHORTSTACK("shortstack", "pos".asOptional(), "text".asRequired(Type.TEXT)),
    SLSHAPE("slshape"),
    SMALL("small"),
    SMALLSKIP("smallskip"),
    SMASH("smash"),
    SOUT("sout", "strikethroughtext".asRequired(Type.TEXT), dependency = ULEM),
    SPACE("space"),
    STEPCOUNTER("stepcounter", "counter".asRequired()),
    STOP("stop"),
    STRETCH("stretch", "factor".asRequired()),
    SUBITEM("subitem"),
    SUBPARAGRAPH("subparagraph", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SUBPARAGRAPH_STAR("subparagraph*", "title".asRequired(Type.TEXT)),
    SUBPARAGRAPHMARK("subparagraphmark", "code".asRequired()),
    SUBSECTION("subsection", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SUBSECTION_STAR("subsection*", "title".asRequired(Type.TEXT)),
    SUBSECTIONMARK("subsectionmark", "code".asRequired()),
    SUBSUBITEM("subsubitem"),
    SUBSUBSECTION("subsubsection", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SUBSUBSECTION_STAR("subsubsection*", "title".asRequired(Type.TEXT)),
    SUBSUBSECTIONMARK("subsubsectionmark", "code".asRequired()),
    SUPPRESSFLOATS("suppressfloats", "placement".asOptional()),
    SYMBOL("symbol", "n".asRequired()),
    TABCOLSEP("tabcolsep"),
    TABLENAME("tablename", "name".asRequired(Type.TEXT)),
    TABLEOFCONTENTS("tableofcontents"),
    TEXTASCIICIRCUM("textasciicircum", display = "^"),
    TEXTASCIITILDE("textasciitilde", display = "~"),
    TEXTASTERISKCENTERED("textasciicentered", display = "⁎"),
    TEXTBACKSLASH("textbackslash", display = "\\"),
    TEXTBAR("textbar", display = "|"),
    TEXTBF("textbf", "text".asRequired(Type.TEXT)),
    TEXTBRACELEFT("textbraceleft", display = "{"),
    TEXTBRACERIGHT("textbraceright", display = "}"),
    TEXTBULLET("textbullet", display = "•"),
    TEXTCIRCLED("textcircled", "text".asRequired()),
    TEXTCOPYRIGHT("textcopyright", display = "©"),
    TEXTDAGGER("textdagger", display = "†"),
    TEXTDAGGERDBL("textdaggerdbl", display = "‡"),
    TEXTDOLLAR("textdollar", display = "$"),
    TEXTELLIPSIS("textellipsis", display = "…"),
    TEXTEMDASH("textemdash", display = "—"),
    TEXTENDASH("textendash", display = "–"),
    TEXTEXCLAMDOWN("textexclamdown", display = "¡"),
    TEXTGREATER("textgreater", display = ">"),
    TEXTHEIGHT("textheight"),
    TEXTIT("textit", "text".asRequired(Type.TEXT)),
    TEXTLESS("textless"),
    TEXTLF("textlf", "text".asRequired(Type.TEXT)),
    TEXTMD("textmd", "text".asRequired(Type.TEXT)),
    TEXTNORMAL("textnormal"),
    TEXTPARAGRAPH("textparagraph"),
    TEXTPERIODCENTERED("textperiodcentered", display = "·"),
    TEXTQUESTIONDOWN("textquestiondown", display = "¿"),
    TEXTQUOTEDBLLEFT("textquotedblleft", display = "“"),
    TEXTQUOTEDBLRIGHT("textquotedblright", display = "”"),
    TEXTQUOTELEFT("textquoteleft", display = "‘"),
    TEXTQUOTERIGHT("textquoteright", display = "’"),
    TEXTREGISTERED("textregistered", display = "®"),
    TEXTRM("textrm", "text".asRequired(Type.TEXT)),
    TEXTSC("textsc", "textsc".asRequired(Type.TEXT)),
    TEXTSECTION("textsection", display = "§"),
    TEXTSF("textsf", "text".asRequired(Type.TEXT)),
    TEXTSL("textsl", "text".asRequired(Type.TEXT)),
    TEXTSTERLING("textsterling", display = "£"),
    TEXTSUBSCRIPT("textsubscript", "text".asRequired(Type.TEXT)),
    TEXTSUPERSCRIPT("textsuperscript", "text".asRequired(Type.TEXT)),
    TEXTTRADEMARK("texttrademark", display = "™"),
    TEXTTT("texttt", "text".asRequired(Type.TEXT)),
    TEXTUNDERSCORE("textunderscore", display = "_"),
    TEXTUP("textup", "text".asRequired(Type.TEXT)),
    TEXTVISIBLESPACE("textvisiblespace", display = "␣"),
    TEXTWIDTH("textwidth"),
    THANKS("thanks", "to".asRequired(Type.TEXT)),
    THICKLINES("thicklines"),
    THINLINES("thinlines"),
    THISPAGESTYLE("thispagestyle", "style".asRequired()),
    TIME("time"),
    TINY("tiny"),
    TITLE("title", "text".asRequired(Type.TEXT)),
    TODAY("today"),
    TOPMARGIN("topmargin"),
    TTFAMILY("ttfamily"),
    TWOCOLUMN("twocolumn", "text".asOptional(Type.TEXT)),
    UNBOLDMATH("unboldmath"),
    UNDERLINE("underline", "text".asRequired(Type.TEXT)),
    UNITLENGTH("unitlength"),
    UPPERCASE("uppercase", "text".asRequired(Type.TEXT)),
    UPSHAPE("upshape"),
    USEPACKAGE("usepackage", "options".asOptional(), "package".asRequired()),
    VDOTS("vdots", display = "⋮"),
    VLINE("vline"),
    VSPACE("vspace", "length".asRequired()),
    VSPACE_STAR("vspace*", "length".asRequired()),
    WIDTH("width"),

    /*
     *  New definitions
     */
    NEWCOMMAND("newcommand", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    NEWCOMMAND_STAR("newcommand*", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    PROVIDECOMMAND("providecommand", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    PROVIDECOMMAND_STAR("providecommand*", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    RENEWCOMMAND("renewcommand", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    RENEWCOMMAND_STAR("renewcommand*", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    NEWENVIRONMENT("newenvironment", "name".asRequired(), "args".asOptional(), "default".asOptional(), "begdef".asRequired(Type.TEXT), "enddef".asRequired(Type.TEXT)),
    RENEWENVIRONMENT("renewenvironment", "name".asRequired(), "args".asOptional(), "default".asOptional(), "begdef".asRequired(Type.TEXT), "enddef".asRequired(Type.TEXT));

    companion object {

        private val lookup = HashMap<String, LatexNoMathCommand>()
        private val lookupDisplay = HashMap<String, LatexNoMathCommand>()

        init {
            for (command in LatexNoMathCommand.values()) {
                lookup[command.command] = command
                if (command.display != null) {
                    lookupDisplay.putIfAbsent(command.display!!, command)
                }
            }
        }

        @JvmStatic
        operator fun get(command: String) = lookup[command]

        @JvmStatic
        fun findByDisplay(display: String) = lookupDisplay[display]
    }
}
