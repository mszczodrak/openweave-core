/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tests.api.java.util;

import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetClass;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

/**
 * @tests java.util.LinkedHashSet
 */

@TestTargetClass(java.util.LinkedHashSet.class)
public class LinkedHashSetTest extends junit.framework.TestCase {

    LinkedHashSet hs;

    Object[] objArray;

    /**
     * @tests java.util.LinkedHashSet#LinkedHashSet()
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "LinkedHashSet",
        args = {}
    )
    public void test_Constructor() {
        // Test for method java.util.LinkedHashSet()
        LinkedHashSet hs2 = new LinkedHashSet();
        assertEquals("Created incorrect LinkedHashSet", 0, hs2.size());
    }

    /**
     * @tests java.util.LinkedHashSet#LinkedHashSet(int)
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "LinkedHashSet",
        args = {int.class}
    )
    public void test_ConstructorI() {
        // Test for method java.util.LinkedHashSet(int)
        LinkedHashSet hs2 = new LinkedHashSet(5);
        assertEquals("Created incorrect LinkedHashSet", 0, hs2.size());
        try {
            new LinkedHashSet(-1);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            //expected
        }
    }

    /**
     * @tests java.util.LinkedHashSet#LinkedHashSet(int, float)
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "LinkedHashSet",
        args = {int.class, float.class}
    )
    public void test_ConstructorIF() {
        // Test for method java.util.LinkedHashSet(int, float)
        LinkedHashSet hs2 = new LinkedHashSet(5, (float) 0.5);
        assertEquals("Created incorrect LinkedHashSet", 0, hs2.size());

        try {
            new LinkedHashSet(-1, 0.5f);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            //expected
        }

        try {
            new LinkedHashSet(1, -0.5f);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            //expected
        }

        try {
            new LinkedHashSet(1, 0f);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            //expected
        }
    }

    /**
     * @tests java.util.LinkedHashSet#LinkedHashSet(java.util.Collection)
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "LinkedHashSet",
        args = {java.util.Collection.class}
    )
    public void test_ConstructorLjava_util_Collection() {
        // Test for method java.util.LinkedHashSet(java.util.Collection)
        LinkedHashSet hs2 = new LinkedHashSet(Arrays.asList(objArray));
        for (int counter = 0; counter < objArray.length; counter++)
            assertTrue("LinkedHashSet does not contain correct elements", hs
                    .contains(objArray[counter]));
        assertTrue("LinkedHashSet created from collection incorrect size", hs2
                .size() == objArray.length);

        try {
            new LinkedHashSet(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
            //expected
        }
    }

    /**
     * @tests java.util.LinkedHashSet#add(java.lang.Object)
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "add",
        args = {java.lang.Object.class}
    )
    public void test_addLjava_lang_Object() {
        // Test for method boolean java.util.LinkedHashSet.add(java.lang.Object)
        int size = hs.size();
        hs.add(new Integer(8));
        assertTrue("Added element already contained by set", hs.size() == size);
        hs.add(new Integer(-9));
        assertTrue("Failed to increment set size after add",
                hs.size() == size + 1);
        assertTrue("Failed to add element to set", hs.contains(new Integer(-9)));
    }

    /**
     * @tests java.util.LinkedHashSet#clear()
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "clear",
        args = {}
    )
    public void test_clear() {
        // Test for method void java.util.LinkedHashSet.clear()
        Set orgSet = (Set) hs.clone();
        hs.clear();
        Iterator i = orgSet.iterator();
        assertEquals("Returned non-zero size after clear", 0, hs.size());
        while (i.hasNext())
            assertTrue("Failed to clear set", !hs.contains(i.next()));
    }

    /**
     * @tests java.util.LinkedHashSet#clone()
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "clone",
        args = {}
    )
    public void test_clone() {
        // Test for method java.lang.Object java.util.LinkedHashSet.clone()
        LinkedHashSet hs2 = (LinkedHashSet) hs.clone();
        assertTrue("clone returned an equivalent LinkedHashSet", hs != hs2);
        assertTrue("clone did not return an equal LinkedHashSet", hs
                .equals(hs2));
    }

    /**
     * @tests java.util.LinkedHashSet#contains(java.lang.Object)
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Verifies null as a parameter.",
        method = "contains",
        args = {java.lang.Object.class}
    )
    public void test_containsLjava_lang_Object() {
        // Test for method boolean
        // java.util.LinkedHashSet.contains(java.lang.Object)
        assertTrue("Returned false for valid object", hs.contains(objArray[90]));
        assertTrue("Returned true for invalid Object", !hs
                .contains(new Object()));

        LinkedHashSet s = new LinkedHashSet();
        s.add(null);
        assertTrue("Cannot handle null", s.contains(null));
    }

    /**
     * @tests java.util.LinkedHashSet#isEmpty()
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "isEmpty",
        args = {}
    )
    public void test_isEmpty() {
        // Test for method boolean java.util.LinkedHashSet.isEmpty()
        assertTrue("Empty set returned false", new LinkedHashSet().isEmpty());
        assertTrue("Non-empty set returned true", !hs.isEmpty());
    }

    /**
     * @tests java.util.LinkedHashSet#iterator()
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "iterator",
        args = {}
    )
    public void test_iterator() {
        // Test for method java.util.Iterator java.util.LinkedHashSet.iterator()
        Iterator i = hs.iterator();
        int x = 0;
        int j;
        for (j = 0; i.hasNext(); j++) {
            Object oo = i.next();
            if (oo != null) {
                Integer ii = (Integer) oo;
                assertTrue("Incorrect element found", ii.intValue() == j);
            } else {
                assertTrue("Cannot find null", hs.contains(oo));
            }
            ++x;
        }
        assertTrue("Returned iteration of incorrect size", hs.size() == x);

        LinkedHashSet s = new LinkedHashSet();
        s.add(null);
        assertNull("Cannot handle null", s.iterator().next());
    }

    /**
     * @tests java.util.LinkedHashSet#remove(java.lang.Object)
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify ClassCastException, NullPointerException, UnsupportedOperationException.",
        method = "remove",
        args = {java.lang.Object.class}
    )
    public void test_removeLjava_lang_Object() {
        // Test for method boolean
        // java.util.LinkedHashSet.remove(java.lang.Object)
        int size = hs.size();
        hs.remove(new Integer(98));
        assertTrue("Failed to remove element", !hs.contains(new Integer(98)));
        assertTrue("Failed to decrement set size", hs.size() == size - 1);

        LinkedHashSet s = new LinkedHashSet();
        s.add(null);
        assertTrue("Cannot handle null", s.remove(null));
    }

    /**
     * @tests java.util.LinkedHashSet#size()
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "size",
        args = {}
    )
    public void test_size() {
        // Test for method int java.util.LinkedHashSet.size()
        assertTrue("Returned incorrect size", hs.size() == (objArray.length + 1));
        hs.clear();
        assertEquals("Cleared set returned non-zero size", 0, hs.size());
    }

    class Mock_LinkedHashSet extends LinkedHashSet {
        @Override
        public boolean retainAll(Collection c) {
            throw new UnsupportedOperationException();
        }
    }

    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "retainAll",
        args = {java.util.Collection.class}
    )
    public void test_retainAllLjava_util_Collection() {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
        Vector v = new Vector<Float>();
        v.add(new Float(3.14));
        lhs.add(new Integer(1));
        assertEquals(1, lhs.size());
        lhs.retainAll(v);
        assertEquals(0, lhs.size());
        v = new Vector<Integer>();
        v.add(new Integer(1));
        v.add(new Integer(2));
        v.add(new Integer(3));
        v.add(new Integer(4));
        v.add(new Integer(5));
        v.add(new Integer(6));
        lhs.add(new Integer(1));
        lhs.add(new Integer(6));
        lhs.add(new Integer(7));
        lhs.add(new Integer(8));
        lhs.add(new Integer(9));
        lhs.add(new Integer(10));
        lhs.add(new Integer(11));
        lhs.add(new Integer(12));
        lhs.add(new Integer(13));
        assertEquals(9, lhs.size());
        lhs.retainAll(v);
        assertEquals(2, lhs.size());

        try {
            lhs.retainAll(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
            //expected
        }

        lhs = new Mock_LinkedHashSet();

        try {
            lhs.retainAll(v);
            fail("UnsupportedOperationException expected");
        } catch (UnsupportedOperationException e) {
            //expected
        }
    }

    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "toArray",
        args = {}
    )
    public void test_toArray() {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
        lhs.add(new Integer(1));
        lhs.add(new Integer(6));
        lhs.add(new Integer(7));
        lhs.add(new Integer(8));
        lhs.add(new Integer(9));
        lhs.add(new Integer(10));
        lhs.add(new Integer(11));
        lhs.add(new Integer(12));
        lhs.add(new Integer(13));

        Object[] o = lhs.toArray();
        for (int i = 0; i < o.length; i++) {
            assertTrue(lhs.contains(o[i]));
        }
        assertEquals(lhs.size(), o.length);
    }

    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "toArray",
        args = {java.lang.Object[].class}
    )
    public void test_toArray$Ljava_lang_Object() {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
        lhs.add(new Integer(1));
        lhs.add(new Integer(6));
        lhs.add(new Integer(7));
        lhs.add(new Integer(8));
        lhs.add(new Integer(9));
        lhs.add(new Integer(10));
        lhs.add(new Integer(11));
        lhs.add(new Integer(12));
        lhs.add(new Integer(13));

        Object[] o1 = new Object[lhs.size()];
        Object[] o2 = new Double[lhs.size()];
        lhs.toArray(o1);
        for (int i = 0; i < o1.length; i++) {
            assertTrue(lhs.contains(o1[i]));
        }

        try {
            lhs.toArray(null);
            fail("NullPointerException expected");
        } catch (NullPointerException e) {
            //expected
        }

        try {
            lhs.toArray(o2);
            fail("ArrayStoreException expected");
        } catch (ArrayStoreException e) {
            //expected
        }
    }

    /**
     * Sets up the fixture, for example, open a network connection. This method
     * is called before a test is executed.
     */
    protected void setUp() {
        objArray = new Object[1000];
        for (int i = 0; i < objArray.length; i++)
            objArray[i] = new Integer(i);

        hs = new LinkedHashSet();
        for (int i = 0; i < objArray.length; i++)
            hs.add(objArray[i]);
        hs.add(null);
    }

    /**
     * Tears down the fixture, for example, close a network connection. This
     * method is called after a test is executed.
     */
    protected void tearDown() {
        objArray = null;
        hs = null;
    }
}
