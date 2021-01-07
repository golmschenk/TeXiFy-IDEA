package nl.hannahsten.texifyidea.util.magic
import com.intellij.openapi.project.Project
import nl.hannahsten.texifyidea.lang.CommandManager
import nl.hannahsten.texifyidea.lang.LatexMathCommand.*
import nl.hannahsten.texifyidea.lang.LatexRegularCommand.*
import java.awt.Color


object CommandMagic {
    /**
     * LaTeX commands that make the text take up more vertical space.
     */
    val high = hashSetOf(
        FRAC.cmd, DFRAC.cmd, SQRT.cmd, SUM.cmd, INT.cmd, IINT.cmd, IIINT.cmd, IIIINT.cmd,
        PROD.cmd, BIGCUP.cmd, BIGCAP.cmd, BIGSQCUP.cmd, BIGSQCAP.cmd
    )

    /**
     * Maps commands to their expected label prefix. Which commands are expected to have a label at all is determined in settings.
     */
    val labeledPrefixes = mapOf(
        CHAPTER.cmd to "ch",
        SECTION.cmd to "sec",
        SUBSECTION.cmd to "subsec",
        SUBSUBSECTION.cmd to "subsubsec",
        ITEM.cmd to "itm"
    )


    /**
     * Level of labeled commands.
     */
    val labeledLevels = mapOf(
        // See page 23 of the LaTeX Companion
        PART to -1, // actually, it is level 0 in classes that do not define \chapter and -1 in book and report
        CHAPTER to 0,
        SECTION to 1,
        SUBSECTION to 2,
        SUBSUBSECTION to 3,
        PARAGRAPH to 4,
        SUBPARAGRAPH to 5
    )

    /**
     * All commands that mark some kind of section.
     */
    val sectionMarkers = listOf(
        PART,
        CHAPTER,
        SECTION,
        SUBSECTION,
        SUBSUBSECTION,
        PARAGRAPH,
        SUBPARAGRAPH
    ).map { it.cmd }

    /**
     * The colours that each section separator has.
     */
    val sectionSeparatorColors = mapOf(
        PART.cmd to Color(152, 152, 152),
        CHAPTER.cmd to Color(172, 172, 172),
        SECTION.cmd to Color(182, 182, 182),
        SUBSECTION.cmd to Color(202, 202, 202),
        SUBSUBSECTION.cmd to Color(212, 212, 212),
        PARAGRAPH.cmd to Color(222, 222, 222),
        SUBPARAGRAPH.cmd to Color(232, 232, 232)
    )

    /**
     * LaTeX commands that increase a counter that can be labeled.
     */
    val increasesCounter = hashSetOf(CAPTION.cmd, CAPTIONOF.cmd) + labeledPrefixes.keys

    /**
     * All commands that represent a reference to a label, excluding user defined commands.
     */
    val labelReferenceWithoutCustomCommands = hashSetOf(
        REF,EQREF,NAMEREF,AUTOREF,FULLREF,PAGEREF,VREF,AUTOREF_CAPITAL,CREF,CREF_CAPITAL,LABELCREF,CPAGEREF
    ).map { it.cmd }.toSet()

    /**
     * All commands that represent a reference to a label, including user defined commands.
     */
    fun getLabelReferenceCommands(project: Project): Set<String> {
        CommandManager.updateAliases(labelReferenceWithoutCustomCommands, project)
        return CommandManager.getAliases(labelReferenceWithoutCustomCommands.first())
    }

    /**
     * All commands that represent a reference to a bibliography entry/item.
     * Commands listed here should also be listed in [nl.hannahsten.texifyidea.lang.LatexRegularCommand].
     */
    @JvmField
    val bibliographyReference = hashSetOf(
        "\\cite", "\\nocite", "\\citep", "\\citep*", "\\citet", "\\citet*", "\\Citep",
        "\\Citep*", "\\Citet", "\\Citet*", "\\citealp", "\\citealp*", "\\citealt", "\\citealt*",
        "\\Citealp", "\\Citealp*", "\\Citealt", "\\Citealt*", "\\citeauthor", "\\citeauthor*",
        "\\Citeauthor", "\\Citeauthor*", "\\citeyear", "\\citeyearpar", "\\parencite", "\\Parencite",
        "\\footcite", "\\footcitetext", "\\textcite", "\\Textcite", "\\smartcite", "\\Smartcite",
        "\\cite*", "\\parencite*", "\\supercite", "\\autocite", "\\Autocite", "\\autocite*",
        "\\Autocite*", "\\citetitle", "\\citetitle*", "\\citeyear*", "\\citedate", "\\citedate*",
        "\\citeurl", "\\volcite", "\\Volcite", "\\pvolcite", "\\Pvolcite", "\\fvolcite",
        "\\Fvolcite", "\\ftvolcite", "\\svolcite", "\\Svolcite", "\\tvolcite", "\\Tvolcite",
        "\\avolcite", "\\Avolcite", "\\fullcite", "\\footfullcite", "\\notecite", "\\Notecite",
        "\\pnotecite", "\\fnotecite"
    )

    /**
     * All commands that represent some kind of reference (think \ref and \cite).
     */
    val reference = labelReferenceWithoutCustomCommands + bibliographyReference

    /**
     * Commands from the import package which require an absolute path as first parameter.
     */
    val absoluteImportCommands = setOf(INCLUDEFROM.cmd, INPUTFROM.cmd, IMPORT.cmd)

    /**
     * Commands from the import package which require a relative path as first parameter.
     */
    val relativeImportCommands = setOf(SUBIMPORT.cmd, SUBINPUTFROM.cmd, SUBINCLUDEFROM.cmd)

    /**
     * All commands for which we assume that commas in required parameters do not separate parameters.
     * By default we assume the comma is a separator.
     */
    val commandsWithNoCommaSeparatedParameters = setOf(INCLUDEGRAPHICS.cmd)

    /**
     * All commands that define labels and that are present by default.
     * To include user defined commands, use [getLabelDefinitionCommands] (may be significantly slower).
     */
    @JvmField
    val labelDefinitionsWithoutCustomCommands = setOf(LABEL.cmd)

    /**
     * Get all commands defining labels, including user defined commands.
     * If you need to know which parameters of user defined commands define a label, use [CommandManager.labelAliasesInfo].
     *
     * This will check if the cache of user defined commands needs to be updated, based on the given project, and therefore may take some time.
     */
    fun getLabelDefinitionCommands(project: Project): Set<String> {
        // Check if updates are needed
        CommandManager.updateAliases(labelDefinitionsWithoutCustomCommands, project)
        return CommandManager.getAliases(labelDefinitionsWithoutCustomCommands.first())
    }

    /**
     * Get all commands defining labels, including user defined commands. This will not check if the aliases need to be updated.
     */
    fun getLabelDefinitionCommands() = CommandManager.getAliases(labelDefinitionsWithoutCustomCommands.first())

    /**
     * All commands that define bibliography items.
     */
    @JvmField
    val bibliographyItems = setOf(BIBITEM.cmd)

    /**
     * All math operators without a leading slash.
     */
    @JvmField
    val slashlessMathOperators = hashSetOf(
        "arccos", "arcsin", "arctan", "arg", "cos", "cosh", "cot", "coth", "csc",
        "deg", "det", "dim", "exp", "gcd", "hom", "inf", "ker", "lg", "lim", "liminf", "limsup",
        "ln", "log", "max", "min", "Pr", "sec", "sin", "sinh", "sup", "tan", "tanh"
    )

    /**
     * All commands that define regular commands, and that require that the command is not already defined.
     */
    val regularStrictCommandDefinitions = hashSetOf(
        NEWCOMMAND.cmd,
        NEWCOMMAND_STAR.cmd,
        NEWIF.cmd,
        NEWDOCUMENTCOMMAND.cmd,
    )

    /**
     * All commands that define or redefine other commands, whether it exists or not.
     */
    val redefinitions = hashSetOf(
        RENEWCOMMAND,
        RENEWCOMMAND_STAR,
        PROVIDECOMMAND, // Does nothing if command exists
        PROVIDECOMMAND_STAR,
        PROVIDEDOCUMENTCOMMAND, // Does nothing if command exists
        DECLAREDOCUMENTCOMMAND,
        DEF,
        LET,
        RENEWENVIRONMENT
    ).map { it.cmd }

    /**
     * All commands that define or redefine regular commands.
     */
    val regularCommandDefinitions = regularStrictCommandDefinitions + redefinitions

    /**
     * All commands that define commands that should be used exclusively
     * in math mode.
     */
    val mathCommandDefinitions = hashSetOf(
        DECLARE_MATH_OPERATOR.cmd,
        DECLARE_PAIRED_DELIMITER.cmd,
        DECLARE_PAIRED_DELIMITER_X.cmd,
        DECLARE_PAIRED_DELIMITER_XPP.cmd
    )

    /**
     * All commands that define new commands.
     */
    val commandDefinitions = regularCommandDefinitions + mathCommandDefinitions

    /**
     * All commands that define new documentclasses.
     */
    val classDefinitions = hashSetOf(PROVIDESCLASS.cmd)

    /**
     * All commands that define new packages.
     */
    val packageDefinitions = hashSetOf(PROVIDESPACKAGE.cmd)

    /**
     * All commands that define new environments.
     */
    val environmentDefinitions = hashSetOf(
        NEWENVIRONMENT,
        NEWTHEOREM,
        NEWDOCUMENTENVIRONMENT,
        PROVIDEDOCUMENTENVIRONMENT,
        DECLAREDOCUMENTENVIRONMENT
    ).map { it.cmd }

    /**
     * All commands that define stuff like classes, environments, and definitions.
     */
    val definitions = commandDefinitions + classDefinitions + packageDefinitions + environmentDefinitions

    /**
     * Commands for which TeXiFy-IDEA has essential custom behaviour and which should not be redefined.
     */
    val fragile = hashSetOf(
        "\\addtocounter", "\\begin", "\\chapter", "\\def", "\\documentclass", "\\end",
        "\\include", "\\includeonly", "\\input", "\\label", "\\let", "\\newcommand",
        "\\overline", "\\paragraph", "\\part", "\\renewcommand", "\\section", "\\setcounter",
        "\\sout", "\\subparagraph", "\\subsection", "\\subsubsection", "\\textbf",
        "\\textit", "\\textsc", "\\textsl", "\\texttt", "\\underline", "\\[", "\\]",
        "\\newenvironment", "\\bibitem",
        "\\NewDocumentCommand",
        "\\ProvideDocumentCommand",
        "\\DeclareDocumentCommand",
        "\\NewDocumentEnvironment",
        "\\ProvideDocumentEnvironment",
        "\\DeclareDocumentEnvironment"
    )

    /**
     * Commands that should not have the given file extensions.
     */
    val illegalExtensions = mapOf(
        INCLUDE.cmd to listOf(".tex"),
        SUBFILEINCLUDE.cmd to listOf(".tex"),
        BIBLIOGRAPHY.cmd to listOf(".bib"),
        INCLUDEGRAPHICS.cmd to listOf(".eps", ".pdf", ".png", ".jpeg", ".jbig2", ".jp2"), // https://tex.stackexchange.com/a/1075/98850
    )

    /**
     * Commands that should have the given file extensions.
     */
    val requiredExtensions = mapOf(
        ADDBIBRESOURCE.cmd to listOf("bib")
    )

    /**
     * Extensions that should only be scanned for the provided include commands.
     */
    val includeOnlyExtensions: Map<String, Set<String>> = mapOf(
        INCLUDE.cmd to hashSetOf("tex"),
        INCLUDEONLY.cmd to hashSetOf("tex"),
        SUBFILE.cmd to hashSetOf("tex"),
        SUBFILEINCLUDE.cmd to hashSetOf("tex"),
        BIBLIOGRAPHY.cmd to hashSetOf("bib"),
        ADDBIBRESOURCE.cmd to hashSetOf("bib"),
        REQUIREPACKAGE.cmd to hashSetOf("sty"),
        USEPACKAGE.cmd to hashSetOf("sty"),
        DOCUMENTCLASS.cmd to hashSetOf("cls"),
        EXTERNALDOCUMENT.cmd to hashSetOf("tex") // Not completely true, as it only includes labels
    )

    val startIfs = hashSetOf(
        IF, IFCAT, IFX,
        IFCASE, IFNUM, IFODD,
        IFHMODE, IFVMODE, IFMMODE,
        IFINNER, IFDIM, IFVOID,
        IFHBOX, IFVBOX, IFEOF,
        IFTRUE, IFFALSE
    ).map { it.cmd }

    /**
     * All commands that end if.
     */
    val endIfs = hashSetOf(FI.cmd)

    /**
     * All commands that at first glance look like \if-esque commands, but that actually aren't.
     */
    val ignoredIfs = hashSetOf("\\newif", "\\iff", "\\ifthenelse", "\\iftoggle", "\\ifoot", "\\ifcsvstrcmp")

    /**
     * List of all TeX style primitives.
     */
    val stylePrimitives = listOf(
        RM.cmd, SF.cmd, TT.cmd, IT.cmd, SL.cmd, SC.cmd, BF.cmd
    )

    /**
     * The LaTeX counterparts of all [stylePrimitives] commands where %s is the content.
     */
    val stylePrimitveReplacements = listOf(
        "\\textrm{%s}", "\\textsf{%s}", "\\texttt{%s}", "\\textit{%s}",
        "\\textsl{%s}", "\\textsc{%s}", "\\textbf{%s}"
    )

    /**
     * Set of text styling commands
     */
    val textStyles = setOf(
        TEXTRM.cmd, TEXTSF.cmd, TEXTTT.cmd, TEXTIT.cmd,
        TEXTSL.cmd, TEXTSC.cmd, TEXTBF.cmd, EMPH.cmd,
        TEXTUP.cmd, TEXTMD.cmd
    )

    /**
     * All LaTeX commands that contain a url (in their first parameter).
     */
    val urls = hashSetOf(URL.cmd, HREF.cmd)

    /**
     * All BibTeX tags that take a url as their parameter.
     */
    val bibUrls = hashSetOf("url", "biburl")

    /**
     * Commands that always contain a certain language.
     *
     * Maps the name of the command to the registered Language id.
     */
    val languageInjections = hashMapOf(
        DIRECTLUA.cmd to "Lua",
        LUAEXEC.cmd to "Lua"
    )
}