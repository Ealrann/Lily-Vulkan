/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl;

import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePkg;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SpritePkgImpl extends PresentationPkgImpl<Sprite> implements SpritePkg
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpritePkgImpl()
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
		return SpritePackage.Literals.SPRITE_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<Sprite> getPresentations()
	{
		if (presentations == null)
		{
			presentations = new EObjectContainmentEList<Sprite>(Sprite.class, this, SpritePackage.SPRITE_PKG__PRESENTATIONS);
		}
		return presentations;
	}

} //SpritePkgImpl
