# Telnyx Meet KMP FastVM benchmark

This directory defines the immutable workload input for Hive's first external Phase 1 coding
benchmark. It does not contain an implementation plan or pre-split agent tickets. Hive is expected
to inspect the repository, compile the mission into a dependency and conflict graph, assign work to
FastVM agents, compare candidates, integrate accepted changes, and return evidence.

## Frozen input

- Repository: `https://github.com/isaacakakpo1/telnyx-meet-android`
- Upstream reference: `https://github.com/team-telnyx/telnyx-meet-android`
- Base commit: `3276e2887c7eced7a4dcbec7f726d7eb0f3d2574`
- Target branch: `kmp-fast-vm-test`
- Product target: Compose Multiplatform application using Kotlin coroutines and Flow
- Authority: work only in the fork and target branch; never push to upstream or either repository's
  `main` branch

The machine-readable mission is in [`mission-brief.json`](mission-brief.json). Observable gates are
in [`acceptance-gates.json`](acceptance-gates.json). The brief is considered changed if either file
changes; a changed digest creates a new benchmark rather than silently changing this one.

## Fairness boundary

The top-level mission is frozen before implementation. Hive, not the operator, must derive the
implementation graph and agent contracts. The same base commit, mission digest, visible gates,
sealed hidden gates, budget, and observation window must be used for the Hive run and the AFK
baseline. A Phase 1 prize claim is not allowed until both runs exist and the deterministic assessor
accepts the evidence.

The legacy Gradle build currently fails before its tests because historical WebRTC/libyuv
artifacts cannot be resolved. That is baseline evidence, not a failure introduced by the KMP
migration. The migrated build must use resolvable, reproducible dependencies.

## Evidence expected from Hive

1. The Queen's generated task, dependency, file-conflict, and symbol-ownership graphs.
2. Every agent assignment, runtime, sandbox, lease, intended write set, cost, and outcome.
3. Candidate comparisons and the evidence used to select or abandon each route.
4. Test, review, CI, integration, conflict, retry, and recovery evidence.
5. A replayable event ledger and an empty FastVM fleet after cleanup.
6. Pull requests targeting `kmp-fast-vm-test`, with no mutation of upstream or `main`.

The benchmark intentionally tests decomposition and coordination. Creating a hand-authored list of
implementation tickets before the run would bypass part of the system being evaluated.
