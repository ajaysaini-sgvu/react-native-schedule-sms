# react-native-schedule-sms
[![npm](https://img.shields.io/npm/v/react-native-schedule-sms.svg?style=flat-square)](https://www.npmjs.com/package/react-native-schedule-sms)

A react native package to schedule SMS at specific dates on android platform.

### Installation

1. Install:
    - Using [npm](https://www.npmjs.com/#getting-started): `npm install react-native-schedule-sms --save`
    - Using [Yarn](https://yarnpkg.com/): `yarn add react-native-schedule-sms`

2. [Link](https://facebook.github.io/react-native/docs/linking-libraries-ios.html):
    - `react-native link react-native-schedule-sms`
    - Or if that fails, link manually using [these steps](https://github.com/cooperka/react-native-snackbar/wiki/Manual-Installation)

3. Import it in your JS:

    ```js
    import Scheduler from 'react-native-schedule-sms';
    ```

### Example

```js
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
    //Date and Time format Thu Aug 31 02:00:00 2017
    Scheduler.sendMessage("mobileNumber", "message", "time");
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

### Methods

| Method Name       | Arguments                                                    | Notes                                |
| -------------     | :-------------:                                              | :----------------:                   |
| sendMessage       | mobile number, text, date & time (EEE MMM dd HH:mm:ss yyyy)  | Schedule a SMS at specific dates

### License

```
Copyright 2017 Ajay Saini (TGMCians).

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```
