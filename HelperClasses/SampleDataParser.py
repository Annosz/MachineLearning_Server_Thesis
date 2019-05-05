import cv2

VIDEO_PATH = "C:\\Users\\Annosz\\Documents\\GitHub\\MachineLearning_Server_Thesis\\data\\out.mp4"
TRAIN_FOLDER = "C:\\Users\\Annosz\\Documents\\GitHub\\MachineLearning_Server_Thesis\\train\\"

def FramesToTrainImages():
    vidObj = cv2.VideoCapture(VIDEO_PATH)

    count = 0
    success = 1
    while success:
        success, image = vidObj.read()
        count += 1
        cv2.imwrite(TRAIN_FOLDER + "frame%d.jpg" % count, image)
