package nl.hannahsten.texifyidea.remotelibraries

import com.intellij.openapi.application.runReadAction
import nl.hannahsten.texifyidea.psi.BibtexEntry
import nl.hannahsten.texifyidea.remotelibraries.state.BibtexEntryListConverter

/**
 * Remote library with a unique [identifier].
 */
abstract class RemoteBibLibrary(open val identifier: String, open val displayName: String) {

    /**
     * Get the bib items from the remote library in bibtex format, then parse the bibtex to obtain all the bib entries.
     */
    suspend fun getCollection(): List<BibtexEntry> {
        val body = getBibtexString()

        // Reading the dummy bib file needs to happen in a place where we have read access.
        return runReadAction {
            BibtexEntryListConverter().fromString(body)
        }
    }

    /**
     * Get the bib items from the remote library in bibtex format.
     */
    abstract suspend fun getBibtexString(): String

    /**
     * Remove any credentials from the password safe.
     *
     * Use `PasswordSafe.instance.set(key, null)` to remove credentials for `key` from the password safe.
     */
    abstract fun destroyCredentials()
}