/**
 */
package org.sheepy.vulkan.model.process.compute.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.Computer;

import org.sheepy.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.compute.impl.ComputerImpl#getShader <em>Shader</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputerImpl extends MinimalEObjectImpl.Container implements Computer
{
	/**
	 * The cached value of the '{@link #getShader() <em>Shader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShader()
	 * @generated
	 * @ordered
	 */
	protected Shader shader;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputerImpl()
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
		return ComputePackage.Literals.COMPUTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shader getShader()
	{
		if (shader != null && shader.eIsProxy())
		{
			InternalEObject oldShader = (InternalEObject)shader;
			shader = (Shader)eResolveProxy(oldShader);
			if (shader != oldShader)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputePackage.COMPUTER__SHADER, oldShader, shader));
			}
		}
		return shader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shader basicGetShader()
	{
		return shader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShader(Shader newShader)
	{
		Shader oldShader = shader;
		shader = newShader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTER__SHADER, oldShader, shader));
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
			case ComputePackage.COMPUTER__SHADER:
				if (resolve) return getShader();
				return basicGetShader();
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
			case ComputePackage.COMPUTER__SHADER:
				setShader((Shader)newValue);
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
			case ComputePackage.COMPUTER__SHADER:
				setShader((Shader)null);
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
			case ComputePackage.COMPUTER__SHADER:
				return shader != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputerImpl
