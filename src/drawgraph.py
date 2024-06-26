# -*- coding: utf-8 -*-
"""drawGraph

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/12m-gw34Vnl8AUj-wwPkNA7w2d8A5sWfl
"""

import ast
import networkx as nx
import matplotlib.pyplot as plt

def create_graph(arr):
    G = nx.DiGraph()
    n = len(arr)

    # Add vertices
    for v, x in arr:
        G.add_node(v)

    # Add edges
    for i, (v, x) in enumerate(arr):
        left_vertex = arr[(i - x) % n][0]
        right_vertex = arr[(i + x) % n][0]
        G.add_edge(v, left_vertex)
        G.add_edge(v, right_vertex)

    return G

def draw_graph(G):
    pos = nx.spring_layout(G)

    # Define colors for each node
    node_colors = ['skyblue', 'lightgreen', 'lightcoral', 'gold', 'lightpink', 'lightblue']

    nx.draw(G, pos, with_labels=True, node_size=1000, font_size=12, font_weight="bold", node_color=node_colors)
    plt.show()

def main():
    input_str = "[ ('I', 2) , ('A', 5) , ('E', 4) , ('F',1) , ('T', 2) , ('S', 3) ]"
    input_pairs = ast.literal_eval(input_str)

    G = create_graph(input_pairs)
    draw_graph(G)

if __name__ == "__main__":
    main()