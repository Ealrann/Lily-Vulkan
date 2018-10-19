/**
 */
package org.sheepy.vulkan.model.process.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.vulkan.model.process.ComputePipeline;
import org.sheepy.vulkan.model.process.Computer;
import org.sheepy.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compute Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl#getComputers <em>Computers</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl#getWorkgroupSizeX <em>Workgroup Size X</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl#getWorkgroupSizeY <em>Workgroup Size Y</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl#getWorkgroupSizeZ <em>Workgroup Size Z</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.ComputePipelineImpl#getDepth <em>Depth</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputePipelineImpl extends AbstractPipelineImpl implements ComputePipeline
{
	/**
	 * The cached value of the '{@link #getComputers() <em>Computers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputers()
	 * @generated
	 * @ordered
	 */
	protected EList<Computer> computers;

	/**
	 * The default value of the '{@link #getWorkgroupSizeX() <em>Workgroup Size X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupSizeX()
	 * @generated
	 * @ordered
	 */
	protected static final int WORKGROUP_SIZE_X_EDEFAULT = 32;

	/**
	 * The cached value of the '{@link #getWorkgroupSizeX() <em>Workgroup Size X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupSizeX()
	 * @generated
	 * @ordered
	 */
	protected int workgroupSizeX = WORKGROUP_SIZE_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkgroupSizeY() <em>Workgroup Size Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupSizeY()
	 * @generated
	 * @ordered
	 */
	protected static final int WORKGROUP_SIZE_Y_EDEFAULT = 32;

	/**
	 * The cached value of the '{@link #getWorkgroupSizeY() <em>Workgroup Size Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupSizeY()
	 * @generated
	 * @ordered
	 */
	protected int workgroupSizeY = WORKGROUP_SIZE_Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorkgroupSizeZ() <em>Workgroup Size Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupSizeZ()
	 * @generated
	 * @ordered
	 */
	protected static final int WORKGROUP_SIZE_Z_EDEFAULT = 32;

	/**
	 * The cached value of the '{@link #getWorkgroupSizeZ() <em>Workgroup Size Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkgroupSizeZ()
	 * @generated
	 * @ordered
	 */
	protected int workgroupSizeZ = WORKGROUP_SIZE_Z_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int DEPTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDepth() <em>Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepth()
	 * @generated
	 * @ordered
	 */
	protected int depth = DEPTH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePipelineImpl()
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
		return ProcessPackage.Literals.COMPUTE_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Computer> getComputers()
	{
		if (computers == null)
		{
			computers = new EObjectContainmentEList<Computer>(Computer.class, this, ProcessPackage.COMPUTE_PIPELINE__COMPUTERS);
		}
		return computers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWorkgroupSizeX()
	{
		return workgroupSizeX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkgroupSizeX(int newWorkgroupSizeX)
	{
		int oldWorkgroupSizeX = workgroupSizeX;
		workgroupSizeX = newWorkgroupSizeX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_X, oldWorkgroupSizeX, workgroupSizeX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWorkgroupSizeY()
	{
		return workgroupSizeY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkgroupSizeY(int newWorkgroupSizeY)
	{
		int oldWorkgroupSizeY = workgroupSizeY;
		workgroupSizeY = newWorkgroupSizeY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y, oldWorkgroupSizeY, workgroupSizeY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWorkgroupSizeZ()
	{
		return workgroupSizeZ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkgroupSizeZ(int newWorkgroupSizeZ)
	{
		int oldWorkgroupSizeZ = workgroupSizeZ;
		workgroupSizeZ = newWorkgroupSizeZ;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z, oldWorkgroupSizeZ, workgroupSizeZ));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth)
	{
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPUTE_PIPELINE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight)
	{
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPUTE_PIPELINE__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDepth()
	{
		return depth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepth(int newDepth)
	{
		int oldDepth = depth;
		depth = newDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPUTE_PIPELINE__DEPTH, oldDepth, depth));
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
			case ProcessPackage.COMPUTE_PIPELINE__COMPUTERS:
				return ((InternalEList<?>)getComputers()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.COMPUTE_PIPELINE__COMPUTERS:
				return getComputers();
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_X:
				return getWorkgroupSizeX();
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y:
				return getWorkgroupSizeY();
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z:
				return getWorkgroupSizeZ();
			case ProcessPackage.COMPUTE_PIPELINE__WIDTH:
				return getWidth();
			case ProcessPackage.COMPUTE_PIPELINE__HEIGHT:
				return getHeight();
			case ProcessPackage.COMPUTE_PIPELINE__DEPTH:
				return getDepth();
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
			case ProcessPackage.COMPUTE_PIPELINE__COMPUTERS:
				getComputers().clear();
				getComputers().addAll((Collection<? extends Computer>)newValue);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_X:
				setWorkgroupSizeX((Integer)newValue);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y:
				setWorkgroupSizeY((Integer)newValue);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z:
				setWorkgroupSizeZ((Integer)newValue);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__DEPTH:
				setDepth((Integer)newValue);
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
			case ProcessPackage.COMPUTE_PIPELINE__COMPUTERS:
				getComputers().clear();
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_X:
				setWorkgroupSizeX(WORKGROUP_SIZE_X_EDEFAULT);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y:
				setWorkgroupSizeY(WORKGROUP_SIZE_Y_EDEFAULT);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z:
				setWorkgroupSizeZ(WORKGROUP_SIZE_Z_EDEFAULT);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case ProcessPackage.COMPUTE_PIPELINE__DEPTH:
				setDepth(DEPTH_EDEFAULT);
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
			case ProcessPackage.COMPUTE_PIPELINE__COMPUTERS:
				return computers != null && !computers.isEmpty();
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_X:
				return workgroupSizeX != WORKGROUP_SIZE_X_EDEFAULT;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Y:
				return workgroupSizeY != WORKGROUP_SIZE_Y_EDEFAULT;
			case ProcessPackage.COMPUTE_PIPELINE__WORKGROUP_SIZE_Z:
				return workgroupSizeZ != WORKGROUP_SIZE_Z_EDEFAULT;
			case ProcessPackage.COMPUTE_PIPELINE__WIDTH:
				return width != WIDTH_EDEFAULT;
			case ProcessPackage.COMPUTE_PIPELINE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case ProcessPackage.COMPUTE_PIPELINE__DEPTH:
				return depth != DEPTH_EDEFAULT;
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
		result.append(" (workgroupSizeX: ");
		result.append(workgroupSizeX);
		result.append(", workgroupSizeY: ");
		result.append(workgroupSizeY);
		result.append(", workgroupSizeZ: ");
		result.append(workgroupSizeZ);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", depth: ");
		result.append(depth);
		result.append(')');
		return result.toString();
	}

} //ComputePipelineImpl
