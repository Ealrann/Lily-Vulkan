/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.lily.core.model.ui.Font;

import org.sheepy.lily.vulkan.model.resource.FontImage;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.FontImageImpl#getFonts <em>Fonts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FontImageImpl extends ImageImpl implements FontImage
{
	/**
	 * The cached value of the '{@link #getFonts() <em>Fonts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFonts()
	 * @generated
	 * @ordered
	 */
	protected EList<Font> fonts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontImageImpl()
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
		return VulkanResourcePackage.Literals.FONT_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Font> getFonts()
	{
		if (fonts == null)
		{
			fonts = new EObjectResolvingEList<Font>(Font.class, this, VulkanResourcePackage.FONT_IMAGE__FONTS);
		}
		return fonts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case VulkanResourcePackage.FONT_IMAGE__FONTS:
				return getFonts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case VulkanResourcePackage.FONT_IMAGE__FONTS:
				getFonts().clear();
				getFonts().addAll((Collection<? extends Font>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case VulkanResourcePackage.FONT_IMAGE__FONTS:
				getFonts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case VulkanResourcePackage.FONT_IMAGE__FONTS:
				return fonts != null && !fonts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FontImageImpl
