package a.star;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.awt.geom.AreaOp;

/**
 *
 * @author Miika
 */
public class NodeTest {
    
    private Node[][] nodeMap;
    private Node node = new Node();
    
    @Before
    public void setUp() {
        MapMaker mapMaker = new MapMaker(10, 10, 500);
        char[][] charMap = mapMaker.createMap();
        mapMaker.createSpace(charMap);
        Logic logic = new Logic(charMap);
        nodeMap = logic.createNodeMap();
    }
    
    @Test
    public void testFindGoalNode() {
        Node returnedGoalNode = node.findGoalNode(nodeMap);
        if(returnedGoalNode != null) {
            fail("Goal was set eventhough it should not have been set");
        }
        nodeMap[0][0].setGoalNode(true);
        returnedGoalNode = node.findGoalNode(nodeMap);
        assertEquals("Returned wrong goal node", nodeMap[0][0], returnedGoalNode);
        nodeMap[0][0].setGoalNode(false);
        nodeMap[8][3].setGoalNode(true);
        returnedGoalNode = node.findGoalNode(nodeMap);
        assertEquals("Returned wrong goal node", nodeMap[8][3], returnedGoalNode);
        assertNotSame("Returned old goal node", nodeMap[0][0], returnedGoalNode);
    }
    
    @Test
    public void testCalculateDistanceToGoal() {
        Node currentNode = nodeMap[2][0];
        nodeMap[5][0].setGoalNode(true);
        int expectedDistance = 3;
        int returnedDistance = node.calculateDistanceToGoal(currentNode, nodeMap);
        assertEquals("Expected distance: " + expectedDistance + " but distance was: "
               + returnedDistance , expectedDistance, returnedDistance);
        
        nodeMap[5][0].setGoalNode(false);
        nodeMap[0][0].setGoalNode(true);
        expectedDistance = 2;
        returnedDistance = node.calculateDistanceToGoal(currentNode, nodeMap);
        assertEquals("Expected distance: " + expectedDistance + " but distance was: "
               + returnedDistance , expectedDistance, returnedDistance);
        
        nodeMap[0][0].setGoalNode(false);
        nodeMap[5][3].setGoalNode(true);
        expectedDistance = 6;
        returnedDistance = node.calculateDistanceToGoal(currentNode, nodeMap);
        assertEquals("Expected distance: " + expectedDistance + " but distance was: "
               + returnedDistance , expectedDistance, returnedDistance);
        
        currentNode = nodeMap[7][5];
        
        nodeMap[5][3].setGoalNode(false);
        nodeMap[8][2].setGoalNode(true);
        expectedDistance = 4;
        returnedDistance = node.calculateDistanceToGoal(currentNode, nodeMap);
        assertEquals("Expected distance: " + expectedDistance + " but distance was: "
               + returnedDistance , expectedDistance, returnedDistance);
    }
    
    /**
     * Testaa samalla myös privaattimetodia setNewGoalNode
     */
    @Test
    public void testMoveGoalNode() {
        
        nodeMap[0][0].setGoalNode(true);
        if(!nodeMap[0][0].isGoalNode()) {
            fail("Goal didnt get set!");
        }
        node.moveGoalNode(nodeMap);
        
        if(nodeMap[0][0].isGoalNode()) {
            fail("Goal didnt move!");
        }
        
        if(!nodeMap[1][0].isGoalNode()) {
            fail("Goal didnt move to expected place!");
        }
        nodeMap[1][0].setGoalNode(false);
        nodeMap[9][0].setGoalNode(true);
        
        node.moveGoalNode(nodeMap);
        
        if(!nodeMap[9][1].isGoalNode()) {
            fail("Goal didnt move to expected place!");
        }
        
        nodeMap[9][1].setGoalNode(false);
        nodeMap[9][9].setGoalNode(true);
        
        node.moveGoalNode(nodeMap);
        
        if(!nodeMap[9][8].isGoalNode()) {
            fail("Goal didnt move to expected place!");
        }
        
    }
    
}
