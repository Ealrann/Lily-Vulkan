/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.Computer;

import org.sheepy.lily.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputerImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputerImpl#getShader <em>Shader</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputerImpl#getWorkgroupCountX <em>Workgroup Count X</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputerImpl#getWorkgroupCountY <em>Workgroup Count Y</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputerImpl#getWorkgroupCountZ <em>Workgroup Count Z</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputerImpl extends MinimalEObjectImpl.Container implements Computer
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

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
	 * The default value of the '{@link #getWorkgroupCountX() <em>Workgroup Count X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupCountX()
	 * @generated
	 * @ordered
	 */
	protected static final int WORKGROUP_COUNT_X_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getWorkgroupCountX() <em>Workgroup Count X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupCountX()
	 * @generated
	 * @ordered
	 */
	protected int workgroupCountX = WORKGROUP_COUNT_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkgroupCountY() <em>Workgroup Count Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupCountY()
	 * @generated
	 * @ordered
	 */
	protected static final int WORKGROUP_COUNT_Y_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getWorkgroupCountY() <em>Workgroup Count Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupCountY()
	 * @generated
	 * @ordered
	 */
	protected int workgroupCountY = WORKGROUP_COUNT_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkgroupCountZ() <em>Workgroup Count Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupCountZ()
	 * @generated
	 * @ordered
	 */
	protected static final int WORKGROUP_COUNT_Z_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getWorkgroupCountZ() <em>Workgroup Count Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupCountZ()
	 * @generated
	 * @ordered
	 */
	protected int workgroupCountZ = WORKGROUP_COUNT_Z_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputerImpl()
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
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ComputePackage.COMPUTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ComputePackage.COMPUTER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Shader getShader()
	{
		if (shader != null && shader.eIsProxy())
		{
			InternalEObject oldShader = (InternalEObject) shader;
			shader = (Shader) eResolveProxy(oldShader);
			if (shader != oldShader)
			{
				if (eNotificationRequired()) eNotify(new ENotificationImpl(this,
						Notification.RESOLVE, ComputePackage.COMPUTER__SHADER, oldShader, shader));
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
	@Override
	public void setShader(Shader newShader)
	{
		Shader oldShader = shader;
		shader = newShader;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ComputePackage.COMPUTER__SHADER, oldShader, shader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWorkgroupCountX()
	{
		return workgroupCountX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkgroupCountX(int newWorkgroupCountX)
	{
		int oldWorkgroupCountX = workgroupCountX;
		workgroupCountX = newWorkgroupCountX;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ComputePackage.COMPUTER__WORKGROUP_COUNT_X, oldWorkgroupCountX, workgroupCountX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWorkgroupCountY()
	{
		return workgroupCountY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkgroupCountY(int newWorkgroupCountY)
	{
		int oldWorkgroupCountY = workgroupCountY;
		workgroupCountY = newWorkgroupCountY;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ComputePackage.COMPUTER__WORKGROUP_COUNT_Y, oldWorkgroupCountY, workgroupCountY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWorkgroupCountZ()
	{
		return workgroupCountZ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWorkgroupCountZ(int newWorkgroupCountZ)
	{
		int oldWorkgroupCountZ = workgroupCountZ;
		workgroupCountZ = newWorkgroupCountZ;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ComputePackage.COMPUTER__WORKGROUP_COUNT_Z, oldWorkgroupCountZ, workgroupCountZ));
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
		case ComputePackage.COMPUTER__NAME:
			return getName();
		case ComputePackage.COMPUTER__ENABLED:
			return isEnabled();
		case ComputePackage.COMPUTER__SHADER:
			if (resolve) return getShader();
			return basicGetShader();
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_X:
			return getWorkgroupCountX();
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Y:
			return getWorkgroupCountY();
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Z:
			return getWorkgroupCountZ();
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
		case ComputePackage.COMPUTER__NAME:
			setName((String) newValue);
			return;
		case ComputePackage.COMPUTER__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case ComputePackage.COMPUTER__SHADER:
			setShader((Shader) newValue);
			return;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_X:
			setWorkgroupCountX((Integer) newValue);
			return;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Y:
			setWorkgroupCountY((Integer) newValue);
			return;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Z:
			setWorkgroupCountZ((Integer) newValue);
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
		case ComputePackage.COMPUTER__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ComputePackage.COMPUTER__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case ComputePackage.COMPUTER__SHADER:
			setShader((Shader) null);
			return;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_X:
			setWorkgroupCountX(WORKGROUP_COUNT_X_EDEFAULT);
			return;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Y:
			setWorkgroupCountY(WORKGROUP_COUNT_Y_EDEFAULT);
			return;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Z:
			setWorkgroupCountZ(WORKGROUP_COUNT_Z_EDEFAULT);
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
		case ComputePackage.COMPUTER__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ComputePackage.COMPUTER__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case ComputePackage.COMPUTER__SHADER:
			return shader != null;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_X:
			return workgroupCountX != WORKGROUP_COUNT_X_EDEFAULT;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Y:
			return workgroupCountY != WORKGROUP_COUNT_Y_EDEFAULT;
		case ComputePackage.COMPUTER__WORKGROUP_COUNT_Z:
			return workgroupCountZ != WORKGROUP_COUNT_Z_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", workgroupCountX: ");
		result.append(workgroupCountX);
		result.append(", workgroupCountY: ");
		result.append(workgroupCountY);
		result.append(", workgroupCountZ: ");
		result.append(workgroupCountZ);
		result.append(')');
		return result.toString();
	}

} //ComputerImpl
