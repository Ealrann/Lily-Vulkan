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
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shader</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl#getFile <em>File</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ShaderImpl#getConstants <em>Constants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShaderImpl extends BasicResourceImpl implements Shader
{
	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected PathResource file;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final EShaderStage STAGE_EDEFAULT = EShaderStage.VERTEX_BIT;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected EShaderStage stage = STAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstants()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecializationConstant> constants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShaderImpl()
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
		return ResourcePackage.Literals.SHADER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathResource getFile()
	{
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFile(PathResource newFile, NotificationChain msgs)
	{
		PathResource oldFile = file;
		file = newFile;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ResourcePackage.SHADER__FILE, oldFile, newFile);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFile(PathResource newFile)
	{
		if (newFile != file)
		{
			NotificationChain msgs = null;
			if (file != null) msgs = ((InternalEObject) file).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ResourcePackage.SHADER__FILE, null, msgs);
			if (newFile != null) msgs = ((InternalEObject) newFile).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - ResourcePackage.SHADER__FILE, null, msgs);
			msgs = basicSetFile(newFile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SHADER__FILE, newFile, newFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EShaderStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(EShaderStage newStage)
	{
		EShaderStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ResourcePackage.SHADER__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SpecializationConstant> getConstants()
	{
		if (constants == null)
		{
			constants = new EObjectContainmentEList<SpecializationConstant>(
					SpecializationConstant.class, this, ResourcePackage.SHADER__CONSTANTS);
		}
		return constants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case ResourcePackage.SHADER__FILE:
			return basicSetFile(null, msgs);
		case ResourcePackage.SHADER__CONSTANTS:
			return ((InternalEList<?>) getConstants()).basicRemove(otherEnd, msgs);
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
		case ResourcePackage.SHADER__FILE:
			return getFile();
		case ResourcePackage.SHADER__STAGE:
			return getStage();
		case ResourcePackage.SHADER__CONSTANTS:
			return getConstants();
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
		case ResourcePackage.SHADER__FILE:
			setFile((PathResource) newValue);
			return;
		case ResourcePackage.SHADER__STAGE:
			setStage((EShaderStage) newValue);
			return;
		case ResourcePackage.SHADER__CONSTANTS:
			getConstants().clear();
			getConstants().addAll((Collection<? extends SpecializationConstant>) newValue);
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
		case ResourcePackage.SHADER__FILE:
			setFile((PathResource) null);
			return;
		case ResourcePackage.SHADER__STAGE:
			setStage(STAGE_EDEFAULT);
			return;
		case ResourcePackage.SHADER__CONSTANTS:
			getConstants().clear();
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
		case ResourcePackage.SHADER__FILE:
			return file != null;
		case ResourcePackage.SHADER__STAGE:
			return stage != STAGE_EDEFAULT;
		case ResourcePackage.SHADER__CONSTANTS:
			return constants != null && !constants.isEmpty();
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
		result.append(" (stage: ");
		result.append(stage);
		result.append(')');
		return result.toString();
	}

} //ShaderImpl
