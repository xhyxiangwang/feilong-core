/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.util.sortutiltest;

import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import static com.feilong.core.util.SortUtil.sortByKeyAsc;

public class SortUtilSortByKeyAscTest{

    /**
     * Test sort by key asc.
     */
    @Test
    public void testSortByKeyAsc(){
        Map<String, Integer> map = new HashMap<>();

        map.put("a", 123);
        map.put("d", 3455);
        map.put(null, 1345);
        map.put("c", 345);
        map.put("b", 8);

        Map<String, Integer> sortByKeyAsc = sortByKeyAsc(map);

        assertThat(sortByKeyAsc.keySet(), contains(null, "a", "b", "c", "d"));
        assertThat(
                        sortByKeyAsc,
                        allOf(hasEntry("a", 123), hasEntry("b", 8), hasEntry("c", 345), hasEntry("d", 3455), hasEntry(null, 1345)));
    }

    //************com.feilong.core.util.SortUtil.sortByKeyAsc(Map<String, Integer>)*****************************
    @Test
    public void testSortByKeyAscNullMap(){
        assertEquals(emptyMap(), sortByKeyAsc(null));
    }

    /**
     * Test sort by key asc 2.
     */
    @Test
    public void testSortByKeyAsc2(){
        assertEquals(emptyMap(), sortByKeyAsc(emptyMap()));
        assertEquals(emptyMap(), sortByKeyAsc(new HashMap<>()));
    }

    /**
     * Test sort.
     */
    @Test
    public void testSort(){
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("a8", 8);
        map.put("a13", 123);
        map.put("a2", 345);

        assertThat(map.keySet(), contains("a8", "a13", "a2"));

        Map<String, Integer> sortByKeyAsc = sortByKeyAsc(map);
        assertThat(sortByKeyAsc.keySet(), contains("a13", "a2", "a8"));
        assertThat(map.keySet(), contains("a8", "a13", "a2"));
    }

}
