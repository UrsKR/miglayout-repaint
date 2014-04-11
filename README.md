This repository illustrates a regression in MigLayout 4.2 with JavaFX 8.
When nodes are added after the layout is first done, node sizes aren't calculated correctly.

In this particular example the button triggers the addition of a label and a Combobox.
The label should be rendered properly, but is instead reduced to minimum size, only to be
shown when the ComboBox is triggered or the Stage is resized.

In JavaFX 2 running on Java 7, the label is shown right after clicking the button.

Tested on OS X 10.9
using JDK 1.8.0 with JavaFX 8
and 1.7.21 with JavaFX 2
with MigLayout 4.2

I have observed the issue on Windows 7 as well.
