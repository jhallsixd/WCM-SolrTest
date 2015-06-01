package com.st.olm.cq.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A utility class for collecting paths efficiently while avoiding duplication.
 * 
 * @author dklco
 */
public class PathCollector {

	private Map<String, Node> tree = new HashMap<String, Node>();

	/**
	 * Collects a path. The rules for collection are:
	 * <ul>
	 * <li>Only one copy of the path at each level will be collected</li>
	 * <li>If any parent path to the current path is collected, the path will be
	 * considered collected</li>
	 * <li>Any child paths to the current path will be discarded</li>
	 * </ul>
	 * 
	 * @param path
	 *            the path to collect
	 */
	public void collect(String path) {
		String[] segments = path.substring(1).split("/");
		Map<String, Node> siblings = tree;
		for (int i = 0; i < segments.length; i++) {
			Node n = siblings.get(segments[i]);
			if (n == null) {
				// create a new node if it doesn't exist
				n = new Node();
				n.segment = segments[i];
				siblings.put(segments[i], n);
			}
			if (n.isLeaf) {
				// we found a previous leaf, quit
				return;
			} else if (i == segments.length - 1) {
				// we have found the last segment of the path
				n.isLeaf = true;
				n.fullPath = path;
				n.children.clear();
			} else {
				// We Need To Go Deeper
				siblings = n.children;
			}
		}
	}

	/**
	 * Gets the paths which have been collected by the PathCollector.
	 * 
	 * @return the list of collected paths
	 */
	public List<String> getPaths() {
		List<String> paths = new ArrayList<String>();
		getPaths(paths, tree);
		return paths;
	}

	/**
	 * A method for recursively traversing the tree of paths and gathering the
	 * collected paths.
	 * 
	 * @param paths
	 *            the list of paths to which to append
	 * @param siblings
	 *            the list of nodes under the current parent
	 */
	private void getPaths(List<String> paths, Map<String, Node> siblings) {
		for (Node n : siblings.values()) {
			if (n.isLeaf) {
				paths.add(n.fullPath);
				return;
			} else {
				getPaths(paths, n.children);
			}
		}
	}
}

class Node {
	String fullPath;

	String segment;
	Map<String, Node> children = new HashMap<String, Node>();
	boolean isLeaf = false;

	@Override
	public int hashCode() {
		return segment.hashCode();
	}

	@Override
	public String toString() {
		return "Node [fullPath=" + fullPath + ", segment=" + segment
				+ ", children=" + children + ", isLeaf=" + isLeaf + "]";
	}

}