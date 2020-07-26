学习笔记

```python
def doubleBFS(graph, start, end):
    visited = set()
	startQueue = [] 
	startQueue.append([start]) 
	while startQueue: 
		node = startQueue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		startQueue.push(nodes)
	# other processing work 
  	endQueue = [] 
	endQueue.append([end]) 
	while endQueue: 
		node = endQueue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		endQueue.push(nodes)
	# other processing work 
    retainall(startQueue, endQueue)
```

