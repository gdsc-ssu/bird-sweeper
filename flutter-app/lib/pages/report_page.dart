import 'package:flutter/material.dart';

class ReportPage extends StatefulWidget {
  const ReportPage({Key? key}) : super(key: key);

  @override
  State<ReportPage> createState() => _ReportPageState();
}

class _ReportPageState extends State<ReportPage> {
  int idx = 0;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(right: 24, left: 24, top: 96),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          Text("Garbage collected",
              style: TextStyle(color: Color(0xFF858580), fontSize: 14)),
          Text("190.82t",
              style: TextStyle(
                  color: Color(0xFF292927),
                  fontSize: 48,
                  fontWeight: FontWeight.w800)),
          SizedBox(
            height: 8,
          ),
          Text("with Bird Sweeper",
              style: TextStyle(color: Color(0xFF858580), fontSize: 14)),
          SizedBox(
            height: 44,
          ),
          Wrap(
            runSpacing: 20,
            children: [
              'Visits',
              'Animal Type',
              'Effective date',
              'Installed device',
              'Number of keepers'
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
