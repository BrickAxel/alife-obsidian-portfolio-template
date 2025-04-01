### Log
[Sub-Symbolic Artificial Chemistries](https://www-users.york.ac.uk/~ss44/bib/ss/nonstd/ssachem2018.pdf)
- The main idea behind sub symbolic artificial chemistry is that reactions should be emergent 
- Basic chemistry provides small units using the periodic table.
- Organic chemistry provides larger units of common biological molecules
- In silico models will be incorrect or partial
- Achem is complete because it's rules can be chosen, but finding ones with emergent behaviors can be hard
- Small number of powerful rules should work
- 𝕊 is the set of possible molecules
- ℝ is the set of rules for interacting the molecules
- 𝔸 is an algorithm describing the dynamics of the environment
- ℝ and 𝔸 must be defined
- ALife in AChem is thought to need self-replication, metabolism, and mutability
- Desirable properties
	- Marcoscorpic
		- unbounded molecular size
		- COM
	- Microscopic
		- synthesis
		- self-synthesis
		- decomposition
- this paper has links that can form and break
- links can bind atoms together or links to atoms or links together
- many systems with different rules and algorithms are built
[Automatically Moving Between Levels in Artificial Chemistries](https://citeseerx.ist.psu.edu/document?repid=rep1&type=pdf&doi=2279f4f977aeaf43af3603ae8ce64618c95fabcb)
- lots of problems in biology and chemistry exist on multiple levels of abstraction
	- most simulations only function on one because moving up or down levels creates issues, like approximations and estimating
- Timescales also creates problems as different levels of abstraction don't necessarily move at the same speed
- moving from higher to lower or vise versa causes different issues.
- moving from high to low requires creating information
- moving from low to high losses information
- claims chemistry should be evolvable
- "either modelling and simulating the whole system from the lower level, and enduring the computational burden that this entails; or modelling the system on both levels simultaneously, switching between the two levels in a multi-level chemistry. To automate the second option requires a well defined way of moving between the levels."
- I dislike the way COM is handled in this paper
- A syntax is created that is pretty much basic chem syntax of molecular reactions 
- A list of how each high level component is made of low level components, how high level components can be isomers, and masses of components
- apply chemistry rules
- To move upwards, the low level system must be left to run to see what structures form.
	- large or unlikely structures are not guaranteed to come into existence. 
- While all major pieces are wanted, intermediate stages from lower stages may not always be appropriate for high level components.
[RBN-World: The Hunt for a Rich AChem](https://citeseerx.ist.psu.edu/document?repid=rep1&type=pdf&doi=58bad7c6e7e5e1f0538c0f41930070aef8bcb840)
- Proposes methods of finding emergent systems in AChem
- Must have some low level properties
- Looks for examples in RBN-Worlds
- Autocatalytic Sets - a molecular species that catayses it's own creation
- Hypercycles - A collection of self replicating cycles
- Heteropolymers - repeated subunits
- Any of these would be really nice for an initial step but are far to computationally intensive to find for every initial step
- Synthesis - bonds are possible but not trivial/universal
- Self-Synthesis - bonds between identical atoms
- Decomposition - breakdown of bonds should be possible but not universal
- Substitution - not inherently import but implies relationships between multiple molecules
- Catalysis - a seris of reactions that don't consume the catalyst but allow for more/faster reactions
- RNB stands for Random Boolean Networks
- RNBs tend to return to a previous state
- Each RBN have bonding sites that are either bonded or unbonded
- 2 or more RBNs form a larger composite RBN
- ![[{8D5EF8F1-341E-404B-824C-8B56C7F99CB4}.png]]
- decomposition test![[{9DFEFD0D-53E7-4B20-99B1-E10D54AC9608}.png]]
- less than 5% of all RNBs pass all the tests
- catalysis test ![[{BCAFF3A6-A50E-4FDB-870E-1033A26F2E66}.png]]
- 
### Next
- [ ]


[[Daily Template|prev]] [[Daily Template|next]]