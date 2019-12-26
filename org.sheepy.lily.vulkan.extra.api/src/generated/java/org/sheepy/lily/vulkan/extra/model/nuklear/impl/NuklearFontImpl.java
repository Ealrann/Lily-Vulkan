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
import org.sheepy.lily.vulkan.model.resource.FontTextureArray;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl#getFontTextureArray <em>Font Texture Array</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearFontImpl extends IResourceImpl implements NuklearFont
{
	/**
	 * The cached value of the '{@link #getFontTextureArray() <em>Font Texture Array</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontTextureArray()
	 * @generated
	 * @ordered
	 */
	protected FontTextureArray fontTextureArray;

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
	public FontTextureArray getFontTextureArray()
	{
		if (fontTextureArray != null && ((EObject)fontTextureArray).eIsProxy())
		{
			InternalEObject oldFontTextureArray = (InternalEObject)fontTextureArray;
			fontTextureArray = (FontTextureArray)eResolveProxy(oldFontTextureArray);
			if (fontTextureArray != oldFontTextureArray)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.NUKLEAR_FONT__FONT_TEXTURE_ARRAY, oldFontTextureArray, fontTextureArray));
			}
		}
		return fontTextureArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontTextureArray basicGetFontTextureArray()
	{
		return fontTextureArray;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFontTextureArray(FontTextureArray newFontTextureArray)
	{
		FontTextureArray oldFontTextureArray = fontTextureArray;
		fontTextureArray = newFontTextureArray;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FONT__FONT_TEXTURE_ARRAY, oldFontTextureArray, fontTextureArray));
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
			case NuklearPackage.NUKLEAR_FONT__FONT_TEXTURE_ARRAY:
				if (resolve) return getFontTextureArray();
				return basicGetFontTextureArray();
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
			case NuklearPackage.NUKLEAR_FONT__FONT_TEXTURE_ARRAY:
				setFontTextureArray((FontTextureArray)newValue);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_TEXTURE_ARRAY:
				setFontTextureArray((FontTextureArray)null);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_TEXTURE_ARRAY:
				return fontTextureArray != null;
		}
		return super.eIsSet(featureID);
	}

} //NuklearFontImpl
