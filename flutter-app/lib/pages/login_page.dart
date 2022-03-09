import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../colors.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          height: double.infinity,
          child: Column(
            children: [
              Container(
                alignment: Alignment.centerRight,
                padding: EdgeInsets.only(top: 12, right: 20),
                child: Text("Sign Up",
                    style: TextStyle(color: PRIMARY_COLOR, fontSize: 16)),
              ),
              SizedBox(height: 72),
              Text("Login",
                  style: TextStyle(
                      color: GRAY_COLOR,
                      fontSize: 48,
                      fontWeight: FontWeight.bold)),
              SizedBox(height: 52),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 24),
                child: Form(
                  child: Column(
                    children: [
                      Container(
                        width: double.infinity,
                        child: Text("ID", style: TextStyle(fontSize: 16)),
                      ),
                      SizedBox(height: 8),
                      TextFormField(
                          obscureText: true,
                          decoration: InputDecoration(
                              hintText: "ID",
                              border: OutlineInputBorder(
                                  borderRadius:
                                      BorderRadius.all(Radius.circular(16))))),
                      SizedBox(height: 40),
                      Container(
                        width: double.infinity,
                        child: Text("Password", style: TextStyle(fontSize: 16)),
                      ),
                      SizedBox(height: 8),
                      TextFormField(
                          obscureText: true,
                          decoration: InputDecoration(
                              hintText: "Password",
                              border: OutlineInputBorder(
                                  borderRadius:
                                      BorderRadius.all(Radius.circular(16))))),
                    ],
                  ),
                ),
              ),
              Expanded(child: SizedBox.shrink()),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 24),
                child: Container(
                  height: 50,
                  width: double.infinity,
                  child: ElevatedButton(
                      onPressed: () {
                        Get.toNamed("/home");
                      },
                      child: Text("Login"),
                      style: ButtonStyle(
                        backgroundColor:
                            MaterialStateProperty.all(PRIMARY_COLOR),
                      )),
                ),
              ),
              SizedBox(
                height: 16,
              )
            ],
          ),
        ),
      ),
    );
  }
}
