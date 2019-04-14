import cv2

VIDEO_PATH = "C:\\Users\\Annosz\\Documents\\GitHub\\MachineLearning_Server_Thesis\\data\\out.mp4"


def FrameCapture():
    extractedImages = list()

    vidObj = cv2.VideoCapture(VIDEO_PATH)

    success = 1
    while success:
        success, image = vidObj.read()
        extractedImages.append(image)

    return extractedImages


def ReadTeachingInput():
    imageList = FrameCapture()

    print(len(imageList))
