/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.application.impl.IResourceImpl;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl#getFontArrayDescriptor <em>Font Array Descriptor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearFontImpl extends IResourceImpl implements NuklearFont
{
	/**
	 * The cached value of the '{@link #getFontArrayDescriptor() <em>Font Array Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontArrayDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ImageArrayDescriptor fontArrayDescriptor;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearFontImpl()
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
		return NuklearPackage.Literals.NUKLEAR_FONT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageArrayDescriptor getFontArrayDescriptor()
	{
		if (fontArrayDescriptor != null && ((EObject)fontArrayDescriptor).eIsProxy())
		{
			InternalEObject oldFontArrayDescriptor = (InternalEObject)fontArrayDescriptor;
			fontArrayDescriptor = (ImageArrayDescriptor)eResolveProxy(oldFontArrayDescriptor);
			if (fontArrayDescriptor != oldFontArrayDescriptor)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_FONT__FONT_ARRAY_DESCRIPTOR, oldFontArrayDescriptor, fontArrayDescriptor));
			}
		}
		return fontArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageArrayDescriptor basicGetFontArrayDescriptor()
	{
		return fontArrayDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFontArrayDescriptor(ImageArrayDescriptor newFontArrayDescriptor)
	{
		ImageArrayDescriptor oldFontArrayDescriptor = fontArrayDescriptor;
		fontArrayDescriptor = newFontArrayDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FONT__FONT_ARRAY_DESCRIPTOR, oldFontArrayDescriptor, fontArrayDescriptor));
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
			case NuklearPackage.NUKLEAR_FONT__FONT_ARRAY_DESCRIPTOR:
				if (resolve) return getFontArrayDescriptor();
				return basicGetFontArrayDescriptor();
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
			case NuklearPackage.NUKLEAR_FONT__FONT_ARRAY_DESCRIPTOR:
				setFontArrayDescriptor((ImageArrayDescriptor)newValue);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_ARRAY_DESCRIPTOR:
				setFontArrayDescriptor((ImageArrayDescriptor)null);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_ARRAY_DESCRIPTOR:
				return fontArrayDescriptor != null;
		}
		return super.eIsSet(featureID);
	}

} //NuklearFontImpl
