
import 'package:flutter/material.dart';
import 'package:flutter_app/pages/manage_page.dart';
import 'package:flutter_app/pages/profile_page.dart';
import 'package:flutter_app/pages/report_page.dart';
import 'package:get/get.dart';

class BottomTabController extends GetxController {
  static BottomTabController get to => Get.find();

  final currentIndex = 0.obs;

  final pages = <Widget>[
    ManagePage(),
    ReportPage(),
    ProfilePage(),
  ];

  Widget get currentPage => pages[currentIndex()];

  changePage(int index) {
    currentIndex.value = index;
  }
}
