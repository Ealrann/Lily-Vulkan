package org.sheepy.lily.vulkan.resource.font.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.sheepy.lily.core.model.ui.UiFactory;

public class CodepointMapTest
{
	@Test
	public void testSame()
	{
		final var font1 = UiFactory.eINSTANCE.createFont();

		final var map1 = Map.of(font1, List.of("123456789"));

		final CodepointMap c1 = CodepointMap.fromCharacterMap(map1);
		final CodepointMap c2 = CodepointMap.fromCharacterMap(map1);

		assertTrue(c1.isCompatible(c2));
		assertTrue(c2.isCompatible(c1));
	}

	@Test
	public void testSub()
	{
		final var font1 = UiFactory.eINSTANCE.createFont();

		final var map1 = Map.of(font1, List.of("123456789"));
		final var mapSub1 = Map.of(font1, List.of("1245679"));
		final var mapPlus1 = Map.of(font1, List.of("123456789a"));

		final CodepointMap c1 = CodepointMap.fromCharacterMap(map1);
		final CodepointMap c2 = CodepointMap.fromCharacterMap(mapSub1);
		final CodepointMap c3 = CodepointMap.fromCharacterMap(mapPlus1);

		assertTrue(c1.isCompatible(c2));
		assertTrue(c3.isCompatible(c2));
		assertTrue(c3.isCompatible(c1));
		assertTrue(c2.isCompatible(c1) == false);
		assertTrue(c1.isCompatible(c3) == false);
	}

	@Test
	public void testMultipleFonts()
	{
		final var font1 = UiFactory.eINSTANCE.createFont();
		final var font2 = UiFactory.eINSTANCE.createFont();

		final var map = Map.of(font1, List.of("123456789"));
		final var mapFontEmpty = Map.of(font1, List.of("123456789"), font2, List.of(""));
		final var mapFontPlus = Map.of(font1, List.of("123456789"), font2, List.of("abc"));

		final CodepointMap c1 = CodepointMap.fromCharacterMap(map);
		final CodepointMap c2 = CodepointMap.fromCharacterMap(mapFontEmpty);
		final CodepointMap c3 = CodepointMap.fromCharacterMap(mapFontPlus);

		assertTrue(c1.isCompatible(c2));
		assertTrue(c3.isCompatible(c2));
		assertTrue(c3.isCompatible(c1));
		assertTrue(c2.isCompatible(c1));
		assertTrue(c1.isCompatible(c3) == false);
	}
}
