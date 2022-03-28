
import 'package:flutter/material.dart';
import 'package:flutter_app/pages/manage_page.dart';
import 'package:flutter_app/pages/profile_page.dart';
import 'package:flutter_app/pages/report_page.dart';
import 'package:get/get.dart';

class DispenserController extends GetxController {
  static DispenserController get to => Get.find();

  final RxList<dynamic> dispenserList = [].obs;
}
