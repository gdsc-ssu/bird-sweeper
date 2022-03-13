import 'package:flutter/material.dart';

class ProfilePage extends StatefulWidget {
  const ProfilePage({Key? key}) : super(key: key);

  @override
  State<ProfilePage> createState() => _ProfilePageState();
}

class _ProfilePageState extends State<ProfilePage> {
  int idx = 0;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(right: 24, left: 24, top: 96),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text("관리자",
              style: TextStyle(color: Color(0xFF858580), fontSize: 14)),
          Text("철수철구 김철수",
              style: TextStyle(
                  color: Color(0xFF292927),
                  fontSize: 48,
                  fontWeight: FontWeight.w800)),
          SizedBox(
            height: 44,
          ),
          Wrap(
            runSpacing: 20,
            children: [
              '담당 지역',
              '담당 기기',
              '어플리케이션 정보',
            ]
                .map((e) => Row(
              children: [
                Text(
                  e,
                  style: TextStyle(
                      color: Color(0xFF858580),
                      fontSize: 14,
                      fontWeight: FontWeight.w500),
                ),
                Expanded(child: SizedBox.shrink()),
                Text("ww",
                    style: TextStyle(
                        color: Color(0xFF292927),
                        fontSize: 16,
                        fontWeight: FontWeight.w600))
              ],
            ))
                .toList(growable: false),
          )
        ],
      ),
    );
  }
}
