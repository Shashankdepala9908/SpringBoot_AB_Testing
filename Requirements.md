Objective
Create a small web application that:

routes users to one of two variants (Alpha/Beta) with sticky assignment, and

captures interaction metrics for analysis.

Functional Requirements
Landing & Sign-in

Landing page with CTA to sign in.

User provides a display name; session established.

A/B Routing

On first sign-in, assign Alpha or Beta using a random (or hash) bucket.

Stickiness: the same user sees the same variant for the session.

Variant Pages

Alpha and Beta must look and read visibly different.

Provide at least two interactive buttons per variant.

Metrics

POST /api/events accepts JSON with buttonId.

Persist timestamp, username, variant, buttonId, ip to H2 via JPA.

Non-Functional Requirements
Java 17+, Spring Boot 3.x

Templating via Thymeleaf

In-memory or file DB (H2 file mode)

Simple logging; show SQL in dev

Clear README and runnable with ./mvnw spring-boot:run

Acceptance Criteria
Sign-in assigns a variant and remains sticky.

Clicking variant buttons writes rows to CLICK_EVENT.

H2 Console query returns recorded events.

README explains setup; repo builds on first try.