import 'package:get/get.dart';

class DispenserController extends GetxController {
  static DispenserController get to => Get.find();

  final RxList<dynamic> dispenserList = [].obs;
  final RxMap dispenser = {}.obs;
}
