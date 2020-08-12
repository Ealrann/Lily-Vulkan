/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontUsage;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

import org.sheepy.lily.vulkan.model.resource.impl.ImageDataProviderImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Image Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.FontImageProviderImpl#getFontUsages <em>Font Usages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FontImageProviderImpl extends ImageDataProviderImpl implements FontImageProvider
{
	/**
	 * The cached value of the '{@link #getFontUsages() <em>Font Usages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<FontUsage> fontUsages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontImageProviderImpl()
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
		return NuklearPackage.Literals.FONT_IMAGE_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FontUsage> getFontUsages()
	{
		if (fontUsages == null)
		{
			fontUsages = new EObjectContainmentEList<FontUsage>(FontUsage.class, this, NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES);
		}
		return fontUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES:
				return ((InternalEList<?>)getFontUsages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES:
				return getFontUsages();
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
			case NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES:
				getFontUsages().clear();
				getFontUsages().addAll((Collection<? extends FontUsage>)newValue);
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
			case NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES:
				getFontUsages().clear();
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
			case NuklearPackage.FONT_IMAGE_PROVIDER__FONT_USAGES:
				return fontUsages != null && !fontUsages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FontImageProviderImpl
