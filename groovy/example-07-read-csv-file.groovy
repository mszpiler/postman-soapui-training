def csvFilePath = "/path/to/csv/file/name.csv"
def fileReader = new BufferedReader(new FileReader(csvFilePath))
def rowsData = fileReader.readLines()