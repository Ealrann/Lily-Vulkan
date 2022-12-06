/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDataProviderImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Image Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.FontImageProviderImpl#getNuklearFont <em>Nuklear Font</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FontImageProviderImpl extends ImageDataProviderImpl implements FontImageProvider
{
	/**
	 * The cached value of the '{@link #getNuklearFont() <em>Nuklear Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNuklearFont()
	 * @generated
	 * @ordered
	 */
	protected NuklearFont nuklearFont;

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
	public NuklearFont getNuklearFont()
	{
		if (nuklearFont != null && ((EObject)nuklearFont).eIsProxy())
		{
			InternalEObject oldNuklearFont = nuklearFont;
			nuklearFont = (NuklearFont)eResolveProxy(oldNuklearFont);
			if (nuklearFont != oldNuklearFont)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.FONT_IMAGE_PROVIDER__NUKLEAR_FONT, oldNuklearFont, nuklearFont));
			}
		}
		return nuklearFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearFont basicGetNuklearFont()
	{
		return nuklearFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNuklearFont(NuklearFont newNuklearFont)
	{
		NuklearFont oldNuklearFont = nuklearFont;
		nuklearFont = newNuklearFont;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.FONT_IMAGE_PROVIDER__NUKLEAR_FONT, oldNuklearFont, nuklearFont));
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
			case NuklearPackage.FONT_IMAGE_PROVIDER__NUKLEAR_FONT:
				if (resolve) return getNuklearFont();
				return basicGetNuklearFont();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case NuklearPackage.FONT_IMAGE_PROVIDER__NUKLEAR_FONT:
				setNuklearFont((NuklearFont)newValue);
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
			case NuklearPackage.FONT_IMAGE_PROVIDER__NUKLEAR_FONT:
				setNuklearFont((NuklearFont)null);
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
			case NuklearPackage.FONT_IMAGE_PROVIDER__NUKLEAR_FONT:
				return nuklearFont != null;
		}
		return super.eIsSet(featureID);
	}

} //FontImageProviderImpl
