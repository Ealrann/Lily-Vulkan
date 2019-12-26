/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Texture2DArray;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Texture2 DArray</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.Texture2DArrayImpl#isMipmapEnabled <em>Mipmap Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Texture2DArrayImpl extends ITextureArrayImpl implements Texture2DArray
{
	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<FileResource> files;

	/**
	 * The default value of the '{@link #isMipmapEnabled() <em>Mipmap Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMipmapEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MIPMAP_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMipmapEnabled() <em>Mipmap Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMipmapEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean mipmapEnabled = MIPMAP_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Texture2DArrayImpl()
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
		return ResourcePackage.Literals.TEXTURE2_DARRAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FileResource> getFiles()
	{
		if (files == null)
		{
			files = new EObjectContainmentEList<FileResource>(FileResource.class, this, ResourcePackage.TEXTURE2_DARRAY__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMipmapEnabled()
	{
		return mipmapEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMipmapEnabled(boolean newMipmapEnabled)
	{
		boolean oldMipmapEnabled = mipmapEnabled;
		mipmapEnabled = newMipmapEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.TEXTURE2_DARRAY__MIPMAP_ENABLED, oldMipmapEnabled, mipmapEnabled));
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
			case ResourcePackage.TEXTURE2_DARRAY__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
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
			case ResourcePackage.TEXTURE2_DARRAY__FILES:
				return getFiles();
			case ResourcePackage.TEXTURE2_DARRAY__MIPMAP_ENABLED:
				return isMipmapEnabled();
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
			case ResourcePackage.TEXTURE2_DARRAY__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends FileResource>)newValue);
				return;
			case ResourcePackage.TEXTURE2_DARRAY__MIPMAP_ENABLED:
				setMipmapEnabled((Boolean)newValue);
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
			case ResourcePackage.TEXTURE2_DARRAY__FILES:
				getFiles().clear();
				return;
			case ResourcePackage.TEXTURE2_DARRAY__MIPMAP_ENABLED:
				setMipmapEnabled(MIPMAP_ENABLED_EDEFAULT);
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
			case ResourcePackage.TEXTURE2_DARRAY__FILES:
				return files != null && !files.isEmpty();
			case ResourcePackage.TEXTURE2_DARRAY__MIPMAP_ENABLED:
				return mipmapEnabled != MIPMAP_ENABLED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (mipmapEnabled: ");
		result.append(mipmapEnabled);
		result.append(')');
		return result.toString();
	}

} //Texture2DArrayImpl
