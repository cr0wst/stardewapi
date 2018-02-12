package net.smcrow.stardewapi.seeding

import java.io.File
import java.nio.charset.Charset

internal abstract class CsvSeeder() {
    /**
     * Generates and stores entities from the passed [fileName].
     */
    abstract fun seed(fileName: String)

    /**
     * Read the [fileName] from the file system.  Additionally the [charset] can be specified.
     */
    protected fun readFile(fileName: String, charset: Charset = Charsets.UTF_8) = File(fileName).readLines(charset = charset)

    /**
     * Convenience function for returning the first row, or header row, from a list of [rows].
     */
    protected fun getHeaderRow(rows: List<String>) = rows.first()

    /**
     * Convenience function for returning all but the first row of [rows].
     */
    protected fun getNonHeaderRows(rows: List<String>) = rows.subList(1, rows.size)

    /**
     * Separate the [row] into columns using the [separator].  By default the [separator] is a ','.
     */
    protected fun getColumns(row: String, separator: Char = ',') = row.split(separator)
}