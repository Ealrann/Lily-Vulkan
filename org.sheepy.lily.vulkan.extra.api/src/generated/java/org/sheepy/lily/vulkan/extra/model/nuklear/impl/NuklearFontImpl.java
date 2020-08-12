/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.resource.impl.IResourceImpl;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl#getFontImage <em>Font Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearFontImpl extends IResourceImpl implements NuklearFont
{
	/**
	 * The cached value of the '{@link #getFontImage() <em>Font Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontImage()
	 * @generated
	 * @ordered
	 */
	protected FontImageProvider fontImage;
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
	public FontImageProvider getFontImage()
	{
		if (fontImage != null && ((EObject)fontImage).eIsProxy())
		{
			InternalEObject oldFontImage = fontImage;
			fontImage = (FontImageProvider)eResolveProxy(oldFontImage);
			if (fontImage != oldFontImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_FONT__FONT_IMAGE, oldFontImage, fontImage));
			}
		}
		return fontImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontImageProvider basicGetFontImage()
	{
		return fontImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFontImage(FontImageProvider newFontImage)
	{
		FontImageProvider oldFontImage = fontImage;
		fontImage = newFontImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FONT__FONT_IMAGE, oldFontImage, fontImage));
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
			case NuklearPackage.NUKLEAR_FONT__FONT_IMAGE:
				if (resolve) return getFontImage();
				return basicGetFontImage();
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
			case NuklearPackage.NUKLEAR_FONT__FONT_IMAGE:
				setFontImage((FontImageProvider)newValue);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_IMAGE:
				setFontImage((FontImageProvider)null);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_IMAGE:
				return fontImage != null;
		}
		return super.eIsSet(featureID);
	}

} //NuklearFontImpl
