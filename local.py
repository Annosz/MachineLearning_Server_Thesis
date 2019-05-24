import livepoly
import argparse


parser = argparse.ArgumentParser(description="Live-poyline training algorithm")

parser.add_argument("--mode", type=int, default=0, metavar='N',
                    help="0: training, 1: test, 2: weight calculation, 3: transfer learning")
parser.add_argument("--memory", type=float, default=0.5, metavar='N',
                    help="the fraction of the memory")
parser.add_argument("--iteration", type=int, default=5, metavar='N',
                    help='the number of overall iterations (including sample generation)')
parser.add_argument("--lr", type=float, default=0.01, metavar='N',
                    help="learning rate")
parser.add_argument("--images-num", type=int, default=1, metavar='N',
                    help="the number of images to use at once for generation")
parser.add_argument("--training-sample-num", type=int, default=16, metavar='N',
                    help="the number of samples to use for a training episode")
parser.add_argument("--test-sample-num", type=int, default=8, metavar='N',
                    help="the number of samples to use for testing")
parser.add_argument("--epochs", type=int, default=1, metavar='N',
                    help="traditional epoch")
parser.add_argument("--model-name", default="model", metavar='S',
                    help="the name of the model which will be loaded")
parser.add_argument("--tfr-img-id", type=int, default=0, metavar='N',
                    help="the image on which transfer learning is applied")


args = parser.parse_args()


if args.mode == 0:
    livepoly.train(args.iteration, args.lr, args.epochs, args.memory, args.images_num, args.training_sample_num, args.test_sample_num)

elif args.mode == 1:
    livepoly.test(args.lr, args.memory)

elif args.mode == 2:
    livepoly.predict(args.model_name, args.memory)

elif args.mode == 3:
    livepoly.transfer(args.tfr_img_id, args.model_name, args.memory)
