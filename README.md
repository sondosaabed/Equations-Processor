# Equations Processor Application

This project involves the implementation of an equation processor application using linked stack and cursor array implementations of a linked list. The application is designed to read equations from a special text file with a .242 extension, process them, and provide various functionalities.

## Equation File Format

The equation file follows a specific format:
1. The file must start with the tag <242> and end with </242>.
2. Within these tags, there can be one or more sections, each starting with < section > and ending with < /section >.
3. Inside a section, there can be optional infix and/or postfix sections, each starting with <infix> or <postfix> and ending with </infix> or </postfix> respectively.
4. Each section contains one or more equations, each starting with <equation> and ending with </equation>.

![image](https://github.com/sondosaabed/Equations-Processor/assets/65151701/0f77516e-c6da-4f45-957d-d75d5bc16b06)


## Loading Equations

1. Click the "Load" button to open a file chooser and select an equation file.
2. The selected file path will be displayed next to the button.
3. The application will check if the file tags are balanced, indicating a valid file.
4. Equations from the first section will be loaded.
5. For infix equations, they are converted to postfix and then evaluated. For postfix equations, they are converted to prefix and then evaluated.

![image](https://github.com/sondosaabed/Equations-Processor/assets/65151701/1df29095-e1f1-44e0-b67a-a8caa03d62a6)

![image](https://github.com/sondosaabed/Equations-Processor/assets/65151701/6c8f301a-914c-4135-a55c-2181116d4ad9)


## Navigation
1. Use the "Next" and "Prev" buttons to navigate through equation sections.
2. "Next" displays equations from the next section (if exists), and "Prev" displays equations from the previous section (if exists).

![image](https://github.com/sondosaabed/Equations-Processor/assets/65151701/74e0c5a7-996b-410f-a180-9447f12603ce)

![image](https://github.com/sondosaabed/Equations-Processor/assets/65151701/b2110045-c2c0-4f16-87ba-da39466df6e9)

![image](https://github.com/sondosaabed/Equations-Processor/assets/65151701/c05eee97-2ce2-4388-9a1e-82d3718fef76)

