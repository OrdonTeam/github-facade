package github.repositories.details

interface DateFormatConverter {
    fun changeDateFormat(date: String, outputFormat: String): String
}