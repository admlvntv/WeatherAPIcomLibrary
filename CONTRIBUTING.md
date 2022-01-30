# How to contribute to WeatherAPIcomLibrary

## Introduction

Hey there, thank you for considering contributing to WeatherAPIcomLibrary! Any contribution helps, no matter the size!

Following this guide helps keep code more consistent, reducing headaches in the future, and ensures that the project flows together well, letting anyone add on to your contribution in the future.

There are many ways you can contribute, from writing documentation and examples, submitting bug reports and feature requests, to writing code that may be included in the code itself.

Please don't use the issue tracker for support questions however. Please use the Discord community server instead

## Basic Ground Rules

First off, our code is a library that can be used by anyone. Please:

- Ensure your code works with any usage of Java. This includes both Maven and Gradle as a dependency, and different types such as Android, and regular Java.

- Make sure your code is formatted as of the standard of the [Google Java Style](https://google.github.io/styleguide/javaguide.html). You can use this using tools like [Google Java Format](https://github.com/google/google-java-format) and the [Google Java Format VScode extension](https://marketplace.visualstudio.com/items?itemName=mngrm3a.vscode-google-java-formatter). Please also keep your code clean with [SonarLint](https://www.sonarlint.org/).

- Ensure your code should be able to succeed all tests, including CI, CodeQL, and linting.

- If you make major changes, such as removing or altering the way a method or class is called, please also make an issue to explain why it needs to be altered, or removed.

- Make sure every method you make has a corresponding JavaDoc comment.

- If you are editing the documentation, be sure to use proper grammar and use the plural "we" and "they" when talking about someone.

- Keep your branches small, avoid having too many major and minor changes in the same branch.

- Be welcoming to everyone. See the [Code of Conduct](https://github.com/AdamCraftmaster/WeatherAPIcomLibrary/blob/main/CODE_OF_CONDUCT.md).

## Your First Contribution

Unsure where to start? Start looking for the good first issue tag in issues, and start a pull request trying to fix or help that issue. 

**Working on your first Pull Request?** You can learn how from this *free* series [How to Contribute to an Open Source Project on GitHub](https://kcd.im/pull-request)

## Getting Started

Contributing is as simple as most other projects.

1. Create a fork of this project

2. In your fork, create a branch. This is how the name should be formatted:
   
   - For documentation, prefix your branch with docs/[BRANCH NAME]
   
   - For features, prefix your branch with feature/[BRANCH NAME]
   
   - For bug fixes, prefix your branch with fix/[BRANCH NAME]

3. Work on your contribution!

4. When you are ready to show off your fancy new contribution, make a pull request! Make sure the title accurately explains what changed, and give a detailed description of what you did in the description.

5. We might ask you to elaborate, or change/fix things. Check your pull request every so often for comments and reviews.

Reviews and comments might not come instantly, as I, the project owner am currently still in school. Reviews and comments will likely come during the weekends.

## How to report a bug

**If you find a security vulnerability, do NOT open an issue. Email admlvntv@gmail.com instead.**

Filing a bug report is simple. Just use the bug report template and give more information. Don't forget to include:

- Add the "Bug" tag to your issue. More tags might be added by a contributor if need be.

- A clear and concise description of what the bug is.

- How to reproduce the bug. This can include a chunk of code that was used (recommended) or a description of the actions you took.

- An error log as a code block, with private information censored.

- Information on what version is used
  
  - Java version
  
  - Maven/Gradle version
  
  - WeatherAPIcomLibrary version

- Any extra information we might want to know

We or a friendly contributor will help you fix the bug when we can.

## How to suggest a feature or enhancement

First of all, our goal is to be a weather library that relies only on weatherapi.com, more weather APIs might be supported in the future, but that is not any time soon. Make sure your feature is possible within the limits of what is given my weatherapi.com.

If you feel a feature is missing, check if others have the same issue as you, it might already be there.

Use the Feature Request template, and make sure to include the following

- Describe the feature you would like

- Describe potential ways to tackle the feature. You don't need to know code, you can describe in words.




