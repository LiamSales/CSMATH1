# CSMATH1

## big project ahead!! personal proj, specs by chatgpt

🎯 Project Idea: Smart Motion Planner (Physics + Math Visualizer)

An Android app in Kotlin where users can input real-world motion scenarios (like throwing a ball, orbit paths, or car acceleration), and the app applies your calculus concepts to analyze and visualize behavior.

🔑 How it applies your math topics
I. Analytic Geometry (Parabola, Ellipse, Hyperbola)

Projectile motion → trajectory is a parabola.

Orbital path → model with ellipse (like planets or satellites).

Light/sound wave paths → hyperbolas (loci of constant differences in distances).
👉 You can let users choose the type of conic and plot it interactively.

II. Functions, Limits, and Continuity

Limits let you check asymptotes in graphs (e.g., velocity/time graphs flatten out).

Show discontinuities in a real-world function (like speed abruptly stopping at a wall).

When graphing a real function (e.g., exponential decay in velocity due to friction), you can visualize its limit at infinity.

III. Derivatives & Differentiation

Derivative of position = velocity, derivative of velocity = acceleration.

Users input a motion equation (like s(t) = -4.9t² + 20t + 5), and the app:

Graphs s(t) (trajectory).

Finds slope of tangent line at a point (v(t) → instantaneous velocity).

Shows second derivative (a(t) → acceleration).
👉 Practical for physics applications.

IV. Behavior of Functions

Extrema: Find max height of a thrown ball (absolute max on an interval).

First derivative test: Show when speed increases or decreases.

Concavity and inflection points: Graph bending direction (e.g., acceleration changing sign).

Optimization: Example—minimum fuel usage for a car, maximum area fenced, etc.

📱 Features of the App

Equation Input + Graphing

User types in function f(x) (or s(t) for motion).

App graphs the function using a graphing library (MPAndroidChart or custom canvas).

Interactive Math Tools

Tangent Line Tool: Tap a point → shows tangent slope.

Derivative/Second Derivative Graphs toggle.

Limit Analyzer: As x → ±∞, show asymptotic behavior.

Physics Scenarios Mode

Projectile motion: computes max height, flight time, range.

Orbit mode: draw ellipse, highlight foci.

Optimization challenges: e.g., "Find the time when velocity is maximum".

Learning Mode

Step-by-step solutions: shows how derivative or limit was computed.

Visual + text explanation of results.

🛠 Kotlin Implementation Details

UI: Jetpack Compose or XML with graph plotting.

Math Engine:

Use exp4j (math expression parser) or build a small parser in Kotlin.

Implement derivative rules yourself for practice (power rule, product rule, chain rule).

Graphing:

MPAndroidChart (easy) or custom Canvas drawing (if you want to really dig in).

Persistence: Save user-created functions with SharedPreferences or SQLite.
