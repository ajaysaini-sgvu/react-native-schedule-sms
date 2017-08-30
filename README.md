# react-native-schedule-sms
[![npm](https://img.shields.io/npm/v/react-native-schedule-sms.svg?style=flat-square)](https://www.npmjs.com/package/react-native-schedule-sms)

A react native package to schedule SMS at specific dates on android platform.

### Installation

```
npm install  react-native-schedule-sms --save
```

### Example

```
/**
 * Created by Ajay on 30/8/2017.
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from "react";
import { AppRegistry, StyleSheet, Button, View } from "react-native";
import Scheduler from "react-native-schedule-sms";

export default class SchduleSMSDemo extends Component {
  constructor(props) {
    super(props);
    this._pressSendMessage = this._pressSendMessage.bind(this);
  }

  render() {
    return (
      <View style={styles.container}>
        <Button
          onPress={this._pressSendMessage}
          title="Send Message"
          color="#841584"
        />
      </View>
    );
  }

  _pressSendMessage() {
    //Time is in this format 8/31/2017, 2:00:00 PM
    Scheduler.sendMessage("Here_Mobile_Number", "Message", "Time");
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF"
  }
});

```
