/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRenderer;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteStructure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SpriteRendererImpl extends GenericRendererImpl<SpriteStructure> implements SpriteRenderer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpriteRendererImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return SpritePackage.Literals.SPRITE_RENDERER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SpriteStructure> getRenderedStructures()
	{
		if (renderedStructures == null) {
			renderedStructures = new EObjectResolvingEList<SpriteStructure>(SpriteStructure.class, this, SpritePackage.SPRITE_RENDERER__RENDERED_STRUCTURES);
		}
		return renderedStructures;
	}

} //SpriteRendererImpl
