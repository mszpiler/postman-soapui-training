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
    request.attachFile(file, true)
}