import cv2


# Function to extract frames
def FrameCapture(path):
    vidObj = cv2.VideoCapture(path)

    extractedImages = list()
    count = 0
    success = 1

    while success:
        success, image = vidObj.read()
        extractedImages.append(image)

    print(extractedImages.count())
