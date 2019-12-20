/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.vulkan.model.resource.FileImage;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.FileImageImpl#isMipmapEnabled <em>Mipmap Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileImageImpl extends ImageImpl implements FileImage
{
	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected FileResource file;

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
	protected FileImageImpl()
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
		return ResourcePackage.Literals.FILE_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileResource getFile()
	{
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFile(FileResource newFile, NotificationChain msgs)
	{
		FileResource oldFile = file;
		file = newFile;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourcePackage.FILE_IMAGE__FILE, oldFile, newFile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFile(FileResource newFile)
	{
		if (newFile != file)
		{
			NotificationChain msgs = null;
			if (file != null)
				msgs = ((InternalEObject)file).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.FILE_IMAGE__FILE, null, msgs);
			if (newFile != null)
				msgs = ((InternalEObject)newFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourcePackage.FILE_IMAGE__FILE, null, msgs);
			msgs = basicSetFile(newFile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.FILE_IMAGE__FILE, newFile, newFile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.FILE_IMAGE__MIPMAP_ENABLED, oldMipmapEnabled, mipmapEnabled));
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
			case ResourcePackage.FILE_IMAGE__FILE:
				return basicSetFile(null, msgs);
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
			case ResourcePackage.FILE_IMAGE__FILE:
				return getFile();
			case ResourcePackage.FILE_IMAGE__MIPMAP_ENABLED:
				return isMipmapEnabled();
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
			case ResourcePackage.FILE_IMAGE__FILE:
				setFile((FileResource)newValue);
				return;
			case ResourcePackage.FILE_IMAGE__MIPMAP_ENABLED:
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
			case ResourcePackage.FILE_IMAGE__FILE:
				setFile((FileResource)null);
				return;
			case ResourcePackage.FILE_IMAGE__MIPMAP_ENABLED:
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
			case ResourcePackage.FILE_IMAGE__FILE:
				return file != null;
			case ResourcePackage.FILE_IMAGE__MIPMAP_ENABLED:
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

} //FileImageImpl
