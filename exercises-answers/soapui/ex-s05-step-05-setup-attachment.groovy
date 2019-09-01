// get request
def request = testRunner.testCase.getTestStepByName("Upload file").testRequest


// clear existing attachments
for (a in request.attachments) {
    request.removeAttachment(a)
}

// get file to attach
def fileName = context.expand('${#Project#imageFileName}')
def filePath = context.expand('${#Project#imageFilePath}')

log.info "file: " + filePath + fileName
def file = new File(filePath + fileName)
if (file == null) {
    log.error "bad filename"
} else {
    //setup header for 'Upload file'
    def uploadFileStep = testRunner.testCase.getTestStepByName("Upload file")
    uploadFileStep.setPropertyValue("file", "file:" + fileName)

    // attach and set properties
    def attachment = request.attachFile(file, true)
    attachment.contentType = "application/octet-stream"
    def list = fileName.tokenize("\\");
    attachment.setPart(list.last())
}