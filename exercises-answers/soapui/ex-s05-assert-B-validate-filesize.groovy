def testCase = messageExchange.modelItem.testCase

//read attachment size from upload step
def uploadsize = testCase.getTestStepByName("Upload file").testRequest.getAttachmentAt(0).getSize()
log.info "uploadsize = " + uploadsize

//read attachment size from download step
def downloadsize = testCase.getTestStepByName("Download file").testRequest.response.getContentLength()
log.info "downloadsize = " + downloadsize

assert uploadsize == downloadsize